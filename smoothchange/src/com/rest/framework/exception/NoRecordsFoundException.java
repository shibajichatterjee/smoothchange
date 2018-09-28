package com.rest.framework.exception;

public class NoRecordsFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {

		return errorMessage;

	}

	public NoRecordsFoundException(String errorMessage) {

		super(errorMessage);

		this.errorMessage = errorMessage;

	}

}
