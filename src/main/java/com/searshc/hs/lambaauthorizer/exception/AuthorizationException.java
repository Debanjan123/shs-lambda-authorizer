package com.searshc.hs.lambaauthorizer.exception;

public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 1972694887392986438L;
	private int statusCode;
	
	public AuthorizationException(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public AuthorizationException(String message, int statusCode, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public AuthorizationException(String message) {
		super(message);
	}

	public AuthorizationException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public AuthorizationException(Throwable cause) {
		super(cause);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
