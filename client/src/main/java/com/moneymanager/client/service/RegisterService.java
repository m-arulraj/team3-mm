package com.moneymanager.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.ErrorResponse;
import com.moneymanager.client.domain.RegisterUser;
import com.moneymanager.client.util.EndPointUri;

@Service
public class RegisterService {

	@Autowired
	RestTemplate restTemplate;
	
	public void registerUser(RegisterUser registerUser) {
		 ResponseEntity<String> result = restTemplate.postForEntity(EndPointUri.USERREGISTER, registerUser, String.class);
		
	}
	
	
}
