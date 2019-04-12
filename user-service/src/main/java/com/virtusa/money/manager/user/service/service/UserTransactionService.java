package com.virtusa.money.manager.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.UserTransactionRepository;

@Service
public class UserTransactionService {

	@Autowired
	UserTransactionRepository userTransactionRepository;



	public UserTransaction storeUserTransaction(UserTransaction userTransaction) {
		return userTransactionRepository.save(userTransaction);
	}

	

}
