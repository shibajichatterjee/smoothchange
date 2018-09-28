package com.rest.framework.exception;


public class UnauthorizedException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {

		return errorMessage;

	}

	public UnauthorizedException(String errorMessage) {

		super(errorMessage);

		this.errorMessage = errorMessage;

	}

}
