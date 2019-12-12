package com.searshc.hs.lambaauthorizer.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searshc.hs.lambaauthorizer.exception.AuthorizationException;
import com.searshc.hs.lambaauthorizer.exception.HSException;
import com.searshc.hs.lambaauthorizer.exception.InvalidInputException;
import com.searshc.hs.lambaauthorizer.utils.Constants;
import com.searshc.hs.lambaauthorizer.utils.Constants.Alphas;
import com.searshc.hs.lambaauthorizer.utils.StringUtils;
import com.searshc.hs.lambaauthorizer.vo.AuthBody;
import com.searshc.hs.lambaauthorizer.vo.Comp;
import com.searshc.hs.lambaauthorizer.vo.CompUri;
import com.searshc.hs.lambaauthorizer.vo.Statement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtTokenValidator {
	private static Logger LOGGER = LoggerFactory.getLogger(JwtTokenValidator.class);
	private static final String TRUSTED_ISSUER = "hssomauthservice.intra.searshc.com";
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final Key signingKey;
	private final String componentName;
	private JwtParser jwtParser;
	
	public JwtTokenValidator(Resource keyFile, String componentName) {
		this.componentName = componentName;
		signingKey = initKey(getResourceContents(keyFile));
		jwtParser = Jwts.parser().setSigningKey(signingKey).requireIssuer(TRUSTED_ISSUER);
	}
	
	private Key initKey(String contents) {
		Key key = null;

		try {
			EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(contents));
			KeyFactory factory = KeyFactory.getInstance("RSA");
			key = factory.generatePublic(keySpec);
		} catch (Exception e) {
			LOGGER.error("Error loading key for signing. Msg: [{}]", e.getMessage());
			throw new HSException(e);
		}

		return key;
	}
	
	private String getResourceContents(Resource keyFile) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(keyFile.getInputStream()))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			LOGGER.error("Error retrieving Path from resource file. Msg: [{}]", e.getMessage());
			throw new HSException(e);
		}
	}

	public List<Statement> buildStatement(APIGatewayProxyRequestEvent request) {
		String authorizationHeader = request.getHeaders().get("Authorization");
		if (StringUtils.isBlank(authorizationHeader)) {
			throw new InvalidInputException("Header 'Authorization' is required");
		}
		
		String[] bearer = authorizationHeader.split(Constants.Alphas.SPACE);
		if (bearer.length < 2 || StringUtils.isNotEqual(Constants.Service.AUTH_BEARER, bearer[0], false)) {
			LOGGER.error("Invalid Authorization header: {}", Arrays.toString(bearer));
			throw new InvalidInputException("Invalid 'Authorization' header value");
		}
		
		Jws<Claims> jws = null;
		try {
			jws = parseToken(bearer[1]);
		} catch (ExpiredJwtException eje) {
			// deliberately not printed error stack trace to reduce noise in application log
			LOGGER.warn(eje.getMessage());
			throw new AuthorizationException("Token is expired", HttpStatus.UNAUTHORIZED.value(), eje);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new HSException("Fatal error occurred in parsing the token", e);
		}

		Claims claims = jws.getBody();

		AuthBody authBody = null;
		
		try {
			authBody = getAuthBodyFromClaims(claims);
		} catch (Exception e) {
			LOGGER.error("Error parsing auth body from claims. Msg: [{}]", e.getMessage());
			throw new HSException("Fatal error occurred in parsing token body", e);
		}
		
		List<Comp> comps = authBody.getComponents();
		if (CollectionUtils.isEmpty(comps)) {
			LOGGER.error("Token not authorized for any components");
			return Collections.emptyList();
		}

		Optional<Comp> comp = comps.stream().filter((c) -> StringUtils.isEqual(c.getName(), componentName, true))
				.findFirst();
		if (!comp.isPresent()) {
			LOGGER.error("Token not authorized for {}", componentName);
			return Collections.emptyList();
		}

		List<CompUri> uris = comp.get().getUris();
		if (CollectionUtils.isEmpty(uris)) {
			LOGGER.error("Token not authorized to any URI");
			return Collections.emptyList();
		}

		List<Statement> statements = new ArrayList<>();
		uris.forEach(compUri -> {
			String componentUri = compUri.getUri();
			String method = null;
			if (componentUri.startsWith(Alphas.OPEN_BACKET)) {
				method = componentUri.substring(1, componentUri.indexOf(Alphas.CLOSED_BACKET));
				componentUri = componentUri.replaceFirst("\\[.*\\]\\s+", Alphas.EMPTY);
			}
			
			APIGatewayProxyRequestEvent.ProxyRequestContext proxyContext = request.getRequestContext();		
			String arn = String.format("arn:aws:execute-api:%s:%s:%s/%s/%s%s", System.getenv("AWS_REGION"), proxyContext.getAccountId(),
					proxyContext.getApiId(), proxyContext.getStage(), StringUtils.isBlank(method) ? proxyContext.getHttpMethod() : method, componentUri);
			statements.add(Statement.builder().resource(arn).effect("Allow").build());
		});
	
		return statements;
	}
		
	/**
	 * This method converts the Map of the auth body in the token to a named
	 * Java object. This makes field retrieval much more convenient.
	 * 
	 * @param claims
	 * @return
	 * @throws IOException
	 */
	protected AuthBody getAuthBodyFromClaims(Claims claims) throws IOException {
		Object auth = claims.get("auth");
		return MAPPER.readValue(MAPPER.writeValueAsBytes(auth), AuthBody.class);
	}

	/**
	 * This method will parse the encoded token into a {@link Jws} object. If
	 * the signature of the token is invalid, the token is expired, the token is
	 * null, or the token is not formed correctly, an exception will be thrown.
	 * 
	 * @param jws
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 */
	protected Jws<Claims> parseToken(String jws) throws ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {
		return jwtParser.parseClaimsJws(jws);
	}
}