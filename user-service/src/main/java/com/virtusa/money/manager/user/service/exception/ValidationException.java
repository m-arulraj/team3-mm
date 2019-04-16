package com.virtusa.money.manager.user.service.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ValidationException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<ObjectError> errors;
	
	public ValidationException(List<ObjectError> errors) {
		super();
		this.errors=errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

}
