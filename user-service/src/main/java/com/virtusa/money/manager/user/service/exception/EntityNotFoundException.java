package com.virtusa.money.manager.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	public EntityNotFoundException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public EntityNotFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public EntityNotFoundException(Throwable t, String message, String errorCode) {
		super(message, t);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
