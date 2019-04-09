package com.virtusa.money.manager.user.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.money.manager.user.service.domain.Role;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.repository.RoleRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	public User saveUser(User user) {
		List<Role> roles=saveRole(user.getRoles());
		user.setRoles(roles);
		return userRepository.save(user);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	private List<Role> saveRole(List<Role> roles) {
		return roleRepository.saveAll(roles);
	}

	public User getUserById(Long id) {
		Optional<User> userObj = userRepository.findById(id);
		return userObj.isPresent()?userObj.get():null;
	}

	public User modifyUser(User user) {
		User storedUser = getUserById(user.getId());
		if(storedUser!=null) {
			storedUser.setUserName(user.getUserName());
			storedUser.setPassword(user.getPassword());
			storedUser.setRoles(user.getRoles());
			return saveUser(storedUser);
		}else {
			return null;
		}
	}

	
}
