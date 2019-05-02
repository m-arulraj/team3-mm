package com.virtusa.money.manager.user.service.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.virtusa.money.manager.user.service.domain.ErrorResponse;
import com.virtusa.money.manager.user.service.domain.Message;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(EntityNotFoundException exception) {
		 ErrorResponse errorResponse = new ErrorResponse(); 
		 List<Message> messages = new ArrayList<Message>(); 
		 Message message = new Message();
		 message.setCode(exception.getErrorCode());
		 message.setMessage(exception.getMessage());
		 messages.add(message);
		 errorResponse.setError(true);
		 errorResponse.setLevel("Error");
		 errorResponse.setMessages(messages);
		 return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception){
		ErrorResponse errorResponse = new ErrorResponse();
		List<Message> messages = new ArrayList<Message>();
		exception.getErrors().forEach(error -> {
			Message message = new Message();
			message.setCode(error.getDefaultMessage().split("-")[0]);
			message.setMessage(error.getDefaultMessage().split("-")[1]);
			messages.add(message);
		});
		errorResponse.setError(true);
		errorResponse.setLevel("Error");
		errorResponse.setMessages(messages);
		System.out.println(errorResponse);
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
		
}
