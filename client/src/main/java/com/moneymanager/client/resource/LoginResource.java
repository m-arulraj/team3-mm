package com.moneymanager.client.resource;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.ClientService;

@Controller

public class LoginResource {
	
	@Autowired
	ClientService clientService;
	
	
	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	@PostMapping("/user-home")
	public String validateUserCredientials(@Valid@ModelAttribute User user,Model model,HttpSession httpSession ) {

		logger.info("home resource user-login page info");
		logger.debug("home resource user-login page debugging");

		System.out.println(user.getUserName());
		System.out.println(user.getPassword());

		User userDb = clientService.getLoginUser(user.getUserName(), user.getPassword());
		if( userDb != null && userDb.getUserName().equalsIgnoreCase(user.getUserName()) && userDb.getPassword().equalsIgnoreCase(user.getPassword())) {
			httpSession.setAttribute("name",userDb.getUserName());
			return "redirect:user-home";
		}else {

			model.addAttribute("login", new User());
			model.addAttribute("error", "Invalid User Credientials");
			return "user-login";
		}
		
	}
	
	
}
