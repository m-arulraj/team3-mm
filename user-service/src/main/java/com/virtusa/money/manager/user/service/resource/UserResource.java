package com.virtusa.money.manager.user.service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) throws URISyntaxException {
		User storedUser = new User();
		storedUser = userService.saveUser(user);
		return ResponseEntity.created(new URI("/api/user/" + storedUser.getId())).build();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		if (user != null) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> modifyUser(@RequestBody User user){
		User updatedUser=userService.modifyUser(user);
		if(updatedUser!=null) {
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
