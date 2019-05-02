package com.moneymanager.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.RegisterUser;
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

	public RegisterUser getUserDetailsByEmailId(String emailId) {
		String uri = EndPointUri.USERDETAILS + "user/" + emailId;
		ResponseEntity<RegisterUser> response = restTemplate.getForEntity(uri, RegisterUser.class);
		RegisterUser user = response.getBody();
		return user;
	}

	public RegisterUser updateProfile(String emailId, RegisterUser user) {

		ResponseEntity<RegisterUser> result = restTemplate
				.postForEntity(EndPointUri.USERDETAILS + "updateProfile/"+emailId, user, RegisterUser.class);

		return result.getBody();

	}

}
