package com.virtusa.money.manager.user.service.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.exception.EntityNotFoundException;
import com.virtusa.money.manager.user.service.exception.ValidationException;
import com.virtusa.money.manager.user.service.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {

	@Autowired
	UserService userService;

	@PostMapping("")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) throws ValidationException{
		if (result.hasErrors()) {
			throw new ValidationException(result.getAllErrors());
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
		}
	}

	@GetMapping("/{user}")
	public ResponseEntity<?> getUser(@PathVariable("user") String name) throws EntityNotFoundException, ValidationException {
		User storedUser = userService.getUserByName(name);
		if (storedUser != null) {
			return ResponseEntity.ok().body(storedUser);
		} else {
			throw new EntityNotFoundException("User data not found", "MM0013");
		}
	}

	@PutMapping("")
	public ResponseEntity<?> modifyUser(@Valid @RequestBody User user,BindingResult result) throws EntityNotFoundException, ValidationException {
		if (result.hasErrors()) {
			throw new ValidationException(result.getAllErrors());
		} else {
			User updatedUser = userService.modifyUser(user);
			if (updatedUser != null) {
				return ResponseEntity.ok().body(updatedUser);
			} else {
				throw new EntityNotFoundException("User data not found", "MM0013");
			}
		}
	}
	
}
