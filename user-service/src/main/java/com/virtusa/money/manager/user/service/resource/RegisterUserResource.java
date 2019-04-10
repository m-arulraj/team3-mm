package com.virtusa.money.manager.user.service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.ErrorResponse;
import com.virtusa.money.manager.user.service.domain.Message;
import com.virtusa.money.manager.user.service.domain.RegisterUser;
import com.virtusa.money.manager.user.service.domain.User;
import com.virtusa.money.manager.user.service.service.RegisterUserService;

@RestController
@RequestMapping(value="/api/register")
public class RegisterUserResource {

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
	
	@Autowired
	RegisterUserService registerUserService;
	
	@PostMapping("")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterUser registerUser ,BindingResult bindingResult) throws URISyntaxException{
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(422).body(populateErrorMessage(bindingResult.getAllErrors()));
		}else {
			RegisterUser registerUser2 = registerUserService.register(registerUser);
			User user = new User();
			user.setUserName(registerUser.getEmailId());
			user.setPassword(registerUser.getPassword());
			
			return ResponseEntity.created(new URI("/api/register/"+registerUser2.getId())).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RegisterUser> getRegisteredUser(@PathVariable("id") Long id){
		RegisterUser registerUser = registerUserService.retriveRegisteredUser(id);
		if(registerUser != null){
			return ResponseEntity.ok().body(registerUser);
		}else{
			return ResponseEntity.notFound().build();
		}
		
	}
}
