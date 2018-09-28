package com.rest.framework.exception;

public class NoEnumRecordsFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {

		return errorMessage;

	}

	public NoEnumRecordsFoundException(String errorMessage) {

		super(errorMessage);

		this.errorMessage = errorMessage;

	}

}
