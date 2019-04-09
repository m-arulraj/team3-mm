package com.virtusa.money.manager.user.service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.RegisterUser;
import com.virtusa.money.manager.user.service.service.RegisterUserService;

@RestController
@RequestMapping(value="/api/register")
public class RegisterUserResource {

	@Autowired
	RegisterUserService registerUserService;
	
	@PostMapping("")
	public ResponseEntity<String> register(@RequestBody RegisterUser registerUser ) throws URISyntaxException{
		RegisterUser registerUser2 = registerUserService.register(registerUser);
		return ResponseEntity.created(new URI("/api/register/"+registerUser2.getId())).build();
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
