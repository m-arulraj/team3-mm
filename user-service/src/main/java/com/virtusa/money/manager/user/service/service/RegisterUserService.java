package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.RegisterUser;
import com.virtusa.money.manager.user.service.repository.RegisterUserRepository;

@Service	
public class RegisterUserService {

	@Autowired
	RegisterUserRepository registerUserRepository;
	
	public RegisterUser register(RegisterUser registration){
		return registerUserRepository.save(registration);
	}
	
	public RegisterUser retriveRegisteredUser(Long id){
		Optional<RegisterUser> registerUser = registerUserRepository.findById(id);

		return 	registerUser.isPresent() ? registerUser.get():null;
				}
}
