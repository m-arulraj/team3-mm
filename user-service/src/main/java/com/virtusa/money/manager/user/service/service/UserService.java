package com.virtusa.money.manager.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	 

	public User getUserByName(String name) {
		Optional<User> userObj = userRepository.findByUserName(name);
		return userObj.isPresent()?userObj.get():null;
	}

	public User modifyUser(User user) {
		User storedUser = getUserByName(user.getUserName());
		if(storedUser!=null) {
			storedUser.setUserName(user.getUserName());
			storedUser.setPassword(user.getPassword());
			return saveUser(storedUser);
		}else {
			return null;
		}
	}

	
}
