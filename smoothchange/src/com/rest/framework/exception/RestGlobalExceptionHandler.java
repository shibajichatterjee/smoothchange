package com.rest.framework.exception;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.framework.bean.ErrorResponse;

@ControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		error.setMessage("Please contact your administrator");

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(SystemException.class)

	public ResponseEntity<ErrorResponse> exceptionHandler1(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());

		error.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.PRECONDITION_FAILED);

	}

	@ExceptionHandler(NoRecordsFoundException.class)

	public ResponseEntity<ErrorResponse> exceptionHandler2(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setErrorCode(HttpStatus.NOT_FOUND.value());

		error.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoEnumRecordsFoundException.class)

	public ResponseEntity<ErrorResponse> exceptionHandler3(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setErrorCode(HttpStatus.NOT_FOUND.value());

		error.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(UnauthorizedException.class)

	public ResponseEntity<ErrorResponse> exceptionHandler4(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setErrorCode(HttpStatus.UNAUTHORIZED.value());

		error.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);

	}

}