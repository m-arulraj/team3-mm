package com.virtusa.money.manager.user.service.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.ErrorResponse;
import com.virtusa.money.manager.user.service.domain.Message;
import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.service.UserTransactionService;

@RestController
@RequestMapping("/api/user-transaction")
public class UserTransactionResource {
	
	@Autowired
	UserTransactionService userTransactionService;

	private ErrorResponse populateErrorMessage(List<ObjectError> errors) {
		System.out.println(errors);
		ErrorResponse errorResponse = new ErrorResponse();
		List<Message> messages = new ArrayList<Message>();
		errors.forEach(error->{
			Message message = new Message();
			message.setCode(error.getDefaultMessage().split("-")[0]);
			message.setMessage(error.getDefaultMessage().split("-")[1]);
			messages.add(message);
		});
		errorResponse.setError(true);
		errorResponse.setLevel("Error");
		errorResponse.setMessages(messages);
		return errorResponse;
		
	}
	@PostMapping("")
	public ResponseEntity<?> storeUserTransaction(@Valid @RequestBody UserTransaction userTransaction,BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(422).body(populateErrorMessage(result.getAllErrors()));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userTransactionService.storeUserTransaction(userTransaction));
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateUserTransacation(@Valid @RequestBody UserTransaction userTransaction,BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.status(422).body(populateErrorMessage(result.getAllErrors()));
		}else {
			userTransaction=userTransactionService.updateUserTransaction(userTransaction);
			if(userTransaction!=null) {
				return ResponseEntity.status(200).body(userTransaction);
			}else {
				return ResponseEntity.status(204).build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeTransaction(@PathVariable Long id){
		if(userTransactionService.removeTransaction(id)==1) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(204).build();
		}
	}
}
