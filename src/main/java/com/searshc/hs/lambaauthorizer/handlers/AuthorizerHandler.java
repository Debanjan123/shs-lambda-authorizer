package com.searshc.hs.lambaauthorizer.handlers;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.searshc.hs.lambaauthorizer.vo.AuthorizerResponse;

public class AuthorizerHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, AuthorizerResponse> {

}
