package com.virtusa.money.manager.user.service.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.exception.EntityNotFoundException;
import com.virtusa.money.manager.user.service.exception.ValidationException;
import com.virtusa.money.manager.user.service.service.UserTransactionService;

@RestController
@RequestMapping("/api/user-transaction")
public class UserTransactionResource {
	
	@Autowired
	UserTransactionService userTransactionService;
	
	@PostMapping("")
	public ResponseEntity<?> storeUserTransaction(@Valid @RequestBody UserTransaction userTransaction,BindingResult result) throws ValidationException {
		if(result.hasErrors()) {
			throw new ValidationException(result.getAllErrors());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userTransactionService.storeUserTransaction(userTransaction));
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateUserTransacation(@Valid @RequestBody UserTransaction userTransaction,BindingResult result) throws ValidationException, EntityNotFoundException{
		if(result.hasErrors()) {
			throw new ValidationException(result.getAllErrors());
		}else {
			userTransaction=userTransactionService.updateUserTransaction(userTransaction);
			if(userTransaction!=null) {
				return ResponseEntity.status(200).body(userTransaction);
			}else {
				throw new EntityNotFoundException("User data not found", "MM0013");
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeTransaction(@PathVariable Long id) throws EntityNotFoundException{
		if(userTransactionService.removeTransaction(id)==1) {
			return ResponseEntity.status(200).build();
		}else {
			throw new EntityNotFoundException("User data not found", "MM0013");
		}
	}
}
