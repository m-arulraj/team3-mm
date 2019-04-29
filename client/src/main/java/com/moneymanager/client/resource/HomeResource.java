package com.moneymanager.client.resource;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

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
	
	@RequestMapping("/welcome")
	public String welcome() {
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
	@GetMapping("/logout")
	public String userLogout(SessionStatus status,HttpSession httpSession) {
		logger.info("Logout resource ");
		status.isComplete();
		httpSession.invalidate();
		return "index";

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

		return "user-transactions";

	}
	/*
	 * @RequestMapping("/user-logout")
	 * 
	 * public String logout(SessionStatus status,HttpSession httpSession) {
	 * 
	 * 
	 * status.isComplete(); String name = (String)httpSession.getAttribute("name");
	 * System.out.println("************************"+name); return "index";
	 * 
	 * }
	 */


}
