package com.moneymanager.client.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.ErrorResponse;
import com.moneymanager.client.domain.Message;
import com.moneymanager.client.domain.RegisterUser;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.RegisterService;

@Controller
public class RegisterResource {

	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);
	
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
			Gson gson = new Gson();
			ErrorResponse convrted = gson.fromJson(e.getResponseBodyAsString(),ErrorResponse.class);
			List<Message> messages = convrted.getMessages();
			List<Message> newMessage = messages.stream().distinct().collect(Collectors.toList());
			model.addAttribute("error", e.getResponseBodyAsByteArray());
			model.addAttribute("mobile", newMessage);
			return "user-registration";
		}  
	}
}