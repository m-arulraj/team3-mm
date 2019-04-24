package com.moneymanager.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.CategoryList;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.domain.UserTransaction;
import com.moneymanager.client.util.EndPointUri;

@Service
public class TransactionService {

	@Autowired
	RestTemplate restTemplate;
	
	public CategoryList getCategoryList(Long id) {
		
		ResponseEntity<CategoryList> categoryList = restTemplate.getForEntity(EndPointUri.CATEGORY+id, CategoryList.class);
		
		return categoryList.getBody();
	}
	public void saveTransaction(UserTransaction transaction,String name) {
		ResponseEntity<User> response = restTemplate.getForEntity(EndPointUri.USERLOGIN+name,User.class);
		User user1 = response.getBody();
		transaction.setUser(user1);
		Long catId= transaction.getCategoryListId();
		CategoryList categoryList = getCategoryList(catId);
		transaction.setCategoryList(categoryList);
		restTemplate.postForEntity(EndPointUri.TRANSACTION, transaction, String.class);
	}
}
