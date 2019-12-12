package com.searshc.hs.lambaauthorizer.utils;

public final class AuthorizerUtils {
	private AuthorizerUtils() {}
	
	public static String toResourceArn(String resourcePath) {
		return resourcePath.replaceAll("/\\{.+\\}", "/*");
	}
}