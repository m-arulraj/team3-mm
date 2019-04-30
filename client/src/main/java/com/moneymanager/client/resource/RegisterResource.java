package com.moneymanager.client.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.moneymanager.client.domain.ErrorResponse;
import com.moneymanager.client.domain.RegisterUser;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.RegisterService;

@Controller
public class RegisterResource {

	@Autowired
	RegisterService registerService;

	@PostMapping("/user/register")
	public String registerUser(@ModelAttribute("register") RegisterUser registerUser, Model model) {

		try {
			registerService.registerUser(registerUser);
			model.addAttribute("login", new User());
			return "user-login";
		} catch (HttpClientErrorException e) {
			model.addAttribute("register", new RegisterUser());

			Object error = e.getResponseBodyAsByteArray();
			ErrorResponse errorResponse = (ErrorResponse) error;
			System.out.println("******************"+errorResponse.getMessages());
			model.addAttribute("error", e.getResponseBodyAsByteArray());
			return "user-registration";
		}
	}
}