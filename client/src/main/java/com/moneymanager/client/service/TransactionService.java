package com.moneymanager.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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

	@Autowired
	ClientService clientService;

	public CategoryList getCategoryList(Long id) {

		ResponseEntity<CategoryList> categoryList = restTemplate.getForEntity(EndPointUri.CATEGORY + id,
				CategoryList.class);

		return categoryList.getBody();
	}

	public void saveTransaction(UserTransaction transaction, String name) {
		ResponseEntity<User> response = restTemplate.getForEntity(EndPointUri.USERLOGIN + name, User.class);
		User user1 = response.getBody();
		transaction.setUser(user1);
		Long catId = transaction.getCategoryListId();
		CategoryList categoryList = getCategoryList(catId);
		transaction.setCategoryList(categoryList);
		restTemplate.postForEntity(EndPointUri.TRANSACTION, transaction, String.class);
	}

	public List<UserTransaction> getTransactions(String name) {
		User user = clientService.getUserByEmailId(name);
		ResponseEntity<List<UserTransaction>> result = restTemplate.exchange(
				EndPointUri.USERTRANSACTIONS + "user/" + user.getId(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserTransaction>>() {
				});

		return result.getBody();
	}

	public UserTransaction getOneTransaction(Long id) {

		ResponseEntity<UserTransaction> transaction = restTemplate.getForEntity(EndPointUri.TRANSACTION + "/" + id,
				UserTransaction.class);

		return transaction.getBody();
	}

	public void updateTransaction(UserTransaction transaction) {

		transaction.setCategoryList(getCategoryList(transaction.getCategoryListId()));
		clientService.getUserByEmailId(transaction.getUserEmail());
		transaction.setUser(clientService.getUserByEmailId(transaction.getUserEmail()));
		restTemplate.postForEntity(EndPointUri.TRANSACTION + "/transaction", transaction, UserTransaction.class);
	}

	public void deleteTransaction(Long id) {

		restTemplate.delete(EndPointUri.TRANSACTION +"/"+id);
	}

}