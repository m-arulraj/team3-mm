package com.moneymanager.client.resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.RegisterUser;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.ClientService;

@Controller
public class HomeResource {

	@Autowired
	ClientService clientService;

	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	@RequestMapping("/")
	public String index() {
		logger.info("home resource index page info");
		logger.debug("home resource index page debugging");
		return "index";
	}

	@GetMapping("/user-login")
	public String userLogin(Model model) {

		logger.info("home resource user-home page info");
		logger.debug("home resource user-home page debugging");

		model.addAttribute("login", new User());
		return "user-login";

	}

	@RequestMapping("/user-home")
	public String userHome() {

		logger.info("home resource user-home page info");
		logger.debug("home resource user-home page debugging");

		return "user-home";

	}

	@RequestMapping("/user-registration")
	public String registration(Model model) {

		logger.info("home resource user-registration page info");
		logger.debug("home resource user-registration page debugging");

		model.addAttribute("register", new RegisterUser());
		return "user-registration";

	}

	@RequestMapping("/user-reports")
	public String reports() {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		return "user-reports";

	}

	@RequestMapping("/user-transactions")

	public String userTransactions() {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		// return "user-transactions";
		return "sample";

	}

	@RequestMapping("/profile-updation")
	  
	  public String logout(@ModelAttribute("profile")User user,Model model) {
		
		model.addAttribute("profile",new RegisterUser());
		return "profile-updation"; 
	  }

}
