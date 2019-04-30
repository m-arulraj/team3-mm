package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.RegisterUser;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.repository.RegisterUserRepository;

@Service
public class RegisterUserService {

	@Autowired
	RegisterUserRepository registerUserRepository;

	@Autowired
	UserService userService;

	public RegisterUser register(RegisterUser registration) {
		User user = new User();
		user.setUserName(registration.getEmailId());
		user.setPassword(registration.getPassword());
		User user2 = userService.saveUser(user);
		registration.setUser(user2);
		return registerUserRepository.save(registration);
	}

	public RegisterUser retriveRegisteredUser(Long id) {
		Optional<RegisterUser> registerUser = registerUserRepository.findById(id);

		return registerUser.isPresent() ? registerUser.get() : null;
	}

	public RegisterUser retriveRegisteredUserByEmailId(String emailId) {
		Optional<RegisterUser> registerUser = registerUserRepository.findByEmailId(emailId);
		return registerUser.isPresent() ? registerUser.get() : null;
	}
	
	@Transactional
	public RegisterUser updateProfile(String emailId, RegisterUser registerUser) {
		RegisterUser user = retriveRegisteredUserByEmailId(emailId);

		if (user != null) {
			return registerUserRepository.save(user);
		} else {
			return registerUserRepository.save(registerUser);
		}

	}
}
