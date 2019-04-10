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
		Optional<Category> category= null;
		Optional<CategoryList> categoryList = null;
		User user = userRepository.findById(userTransaction.getUser().getId()).get();
		category = categoryRepository.findById(userTransaction.getCategoryList().getCategory().getId());
		categoryList=categoryListRepository.findById(userTransaction.getCategoryList().getId());
		if(category.isPresent()) {
			if(categoryList.isPresent()) {
				categoryList.get().setCategory(category.get());
				userTransaction.setCategoryList(categoryList.get());
				userTransaction.setUser(user);
				return userTransactionRepository.save(userTransaction);
			}else {
				CategoryList saveCategoryList = categoryListRepository.save(userTransaction.getCategoryList());
				categoryRepository.save(userTransaction.getCategoryList().setCategory(category.get()))
			}
		}
	}

}
