package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.CategoryList;
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

		Optional<CategoryList> categoryList = null;
		categoryList = categoryListRepository.findByName(userTransaction.getCategoryList().getName());
		userTransaction.setUser(userRepository.findById(userTransaction.getUser().getId()).get());
		if (categoryList.isPresent()) {
			categoryList.get().setCategory(
					categoryRepository.findById(userTransaction.getCategoryList().getCategory().getId()).get());
			userTransaction.setCategoryList(categoryList.get());
			return userTransactionRepository.save(userTransaction);
		} else {
			CategoryList saveCategoryList = categoryListRepository.save(userTransaction.getCategoryList());
			userTransaction.setCategoryList(saveCategoryList);
			return userTransactionRepository.save(userTransaction);
		}
	}

	public int removeTransaction(Long id) {
		if (userTransactionRepository.findById(id).isPresent()) {
			userTransactionRepository.deleteById(id);
			return 1;
		} else {
			return 0;
		}
	}

	public UserTransaction updateUserTransaction(UserTransaction userTransaction) {
		Optional<UserTransaction> storedUserTransaction = userTransactionRepository.findById(userTransaction.getId());
		if (storedUserTransaction.isPresent()) {

			UserTransaction transaction = storedUserTransaction.get();
			transaction.setId(userTransaction.getId());
			transaction.setAmount(userTransaction.getAmount());
			transaction.setDate(userTransaction.getDate());
			transaction.setCategoryList(userTransaction.getCategoryList());
			transaction.setUser(userTransaction.getUser());
			return storeUserTransaction(transaction);
		} else {
			return null;
		}
	}
	
}
