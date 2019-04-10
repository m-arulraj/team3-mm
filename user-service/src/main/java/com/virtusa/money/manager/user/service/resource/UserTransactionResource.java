package com.virtusa.money.manager.user.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.UserTransaction;

@RestController
@RequestMapping("/user-transaction")
public class UserTransactionResource {
	
	@Autowired
	UserTransactionService userTransactionService;

	@PostMapping("")
	public ResponseEntity<?> storeUserTransaction(@RequestBody UserTransaction userTransaction) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userTransactionService.storeUserTransaction(userTransaction));
	}
}
