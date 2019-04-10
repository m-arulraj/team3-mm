package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.Category;
import com.virtusa.money.manager.user.service.domain.CategoryList;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;
import com.virtusa.money.manager.user.service.repository.UserTransactionRepository;

@Service
public class UserTransactionService {
	
	@Autowired
	UserTransactionRepository userTransactionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryListRepository categoryListRepository;
	
	@Autowired
	UserRepository userRepository;

	public UserTransaction storeUserTransaction(UserTransaction userTransaction) {
		return userTransactionRepository.save(userTransaction);
	}

}
