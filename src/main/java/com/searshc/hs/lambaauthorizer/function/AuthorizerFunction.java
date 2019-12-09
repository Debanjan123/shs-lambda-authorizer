package com.searshc.hs.lambaauthorizer.function;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.searshc.hs.lambaauthorizer.vo.AuthorizerResponse;
import com.searshc.hs.lambaauthorizer.vo.PolicyDocument;
import com.searshc.hs.lambaauthorizer.vo.Statement;

@Component("AuthorizerFunction")
public class AuthorizerFunction implements Function<APIGatewayProxyRequestEvent, AuthorizerResponse> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerFunction.class);

	@Override
	public AuthorizerResponse apply(APIGatewayProxyRequestEvent request) {
		LOGGER.info("APIGatewayProxyRequestEvent => {}", request);
		List<Statement> statementList = null;
		
		try {
			JwtTokenValidator jwtTokenValidator = new JwtTokenValidator(new ClassPathResource(System.getenv("JWT_PUBLIC_KEY")),
					request.getStageVariables().get("AUTH_COMPONENT"));			
			statementList = jwtTokenValidator.buildStatement(request);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		Map<String, String> ctx = new HashMap<>();
		ctx.put("user", "gbhosal");
		
		PolicyDocument policyDocument = PolicyDocument.builder()
				.statements(statementList == null ? Collections.emptyList() : statementList).build();
		
		APIGatewayProxyRequestEvent.ProxyRequestContext proxyContext = request.getRequestContext();
		AuthorizerResponse authorizerResponse = AuthorizerResponse.builder().principalId(proxyContext.getAccountId()).policyDocument(policyDocument)
				.context(ctx).build();
		
		LOGGER.info("AuthorizerResponse => {}", authorizerResponse);
		return authorizerResponse;
	}
}