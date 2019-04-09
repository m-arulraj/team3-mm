package com.virtusa.money.manager.user.service.resource;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.ErrorResponse;
import com.virtusa.money.manager.user.service.domain.Message;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {

	@Autowired
	UserService userService;

	private ErrorResponse populateErrorMessage(List<ObjectError> errors) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<Message> messages = new ArrayList<Message>();
		errors.forEach(error -> {
			Message message = new Message();
			message.setCode(error.getDefaultMessage().split("-")[0]);
			message.setMessage(error.getDefaultMessage().split("-")[1]);
			messages.add(message);
		});
		errorResponse.setError(true);
		errorResponse.setLevel("Error");
		errorResponse.setMessages(messages);
		return errorResponse;
	}

	@PostMapping("")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) throws URISyntaxException {
		if (result.hasErrors()) {
			return ResponseEntity.status(422).body(populateErrorMessage(result.getAllErrors()));
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		if (user != null) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PutMapping("")
	public ResponseEntity<?> modifyUser(@Valid @RequestBody User user,BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(422).body(populateErrorMessage(result.getAllErrors()));
		} else {
			User updatedUser = userService.modifyUser(user);
			if (updatedUser != null) {
				return ResponseEntity.ok().body(updatedUser);
			} else {
				return ResponseEntity.status(204).build();
			}
		}
	}
}
