package com.moneymanager.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.User;
import com.moneymanager.client.util.EndPointUri;

@Service
public class ClientService {

	@Autowired
	RestTemplate restTemplate;

	public User getUserByEmailId(String emailId) {
		String uri = EndPointUri.USERLOGIN + emailId;
		ResponseEntity<User> response = restTemplate.getForEntity(uri, User.class);
		User user1 = response.getBody();
		return user1;
	}
	
	public User getLoginUser(String userName, String password) {

		String uri = EndPointUri.USERLOGIN + userName;
		ResponseEntity<User> response = restTemplate.getForEntity(uri, User.class);
		User user1 = response.getBody();
		return user1;
	}

	
}
