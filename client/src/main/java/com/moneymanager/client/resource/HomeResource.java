package com.moneymanager.client.resource;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.ErrorResponse;
import com.moneymanager.client.domain.RegisterUser;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.service.ClientService;

@Controller
public class HomeResource  {

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

	@RequestMapping(value = "/user-home", method = RequestMethod.GET)
	public ModelAndView userHome(Principal principal) {

		logger.info("home resource user-home page info");
		logger.debug("home resource user-home page debugging");

		principal.getName();
		return new ModelAndView("user-home");

	}

	@RequestMapping("/user-registration")
	public String registration(Model model) {

		logger.info("home resource user-registration page info");
		logger.debug("home resource user-registration page debugging");

		model.addAttribute("register", new RegisterUser());
		return "user-registration";

	}

	@RequestMapping("/user-reports")
	public String reports(Principal principal) {

		principal.getName();
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

	public String profileUpdation(@ModelAttribute("profile") User user, Model model, Principal principal) {
		String emailId = principal.getName();
		RegisterUser registerUser = clientService.getUserDetailsByEmailId(emailId);
		registerUser.setPassword(registerUser.getUser().getPassword());
		registerUser.setConfirmPassword(registerUser.getUser().getPassword());
		model.addAttribute("profile", registerUser);
		return "profile-updation";
	}

	@PostMapping("/profile-updation")

	public String profileUpdate(@ModelAttribute("profile") RegisterUser user, Model model, Principal principal) {
		try {
		String emailId = principal.getName();
		clientService.updateProfile(emailId,user);
		return "profile-updation";
		}catch (HttpClientErrorException e) {
			model.addAttribute("error", e.getResponseBodyAsString());
			Gson gson = new Gson();
			ErrorResponse convrted = gson.fromJson(e.getResponseBodyAsString(),ErrorResponse.class);
			
			String emailId = principal.getName();
			RegisterUser registerUser = clientService.getUserDetailsByEmailId(emailId);
			registerUser.setPassword(registerUser.getUser().getPassword());
			registerUser.setConfirmPassword(registerUser.getUser().getPassword());
			model.addAttribute("profile", registerUser);
			return "profile-updation";
		}
		
	}
	@ExceptionHandler(NullPointerException.class)
	public String handleError() {

		return "error-page";
	}
	
	@RequestMapping("/forgot-password")
	public String forgotPassword(Model model) {
		logger.info("home resource forgot-password page info");
		logger.debug("home resource forgot-password page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "forgot-password";

	}
	@PostMapping("/forgotPassword")
	public String forgotUserPassword(@ModelAttribute("forgotPassword")RegisterUser registerUser) {
		String emailId=registerUser.getEmailId();
		
		RegisterUser  object=clientService.getUserDetailsByEmailId(emailId);
		 System.out.println(object);
		logger.info("home resource forgot-password page info");
		logger.debug("home resource forgot-password page debugging");
		return "forgot-password";
	}
	
	
	@RequestMapping("/budgetControl")
	public String budgetControl(Model model) {
		logger.info("home resource budgetControl page info");
		logger.debug("home resource budgetControl page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "budget-control-story";

	}
	
	
	@RequestMapping("/overspending")
	public String overSpending(Model model) {
		logger.info("home resource overspending page info");
		logger.debug("home resource overspending page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "overspending-story";

	}
	
	
	@RequestMapping("/splitexpense")
	public String splitExpense(Model model) {
		logger.info("home resource splitexpense page info");
		logger.debug("home resource splitexpense page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "split-expense-story";

	}
	
	@RequestMapping("/purchase")
	public String purchase(Model model) {
		logger.info("home resource purchase page info");
		logger.debug("home resource purchase page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "purchase-story";

	}
	@RequestMapping("/broke")
	public String broke(Model model) {
		logger.info("home resource purchase page info");
		logger.debug("home resource purchase page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "broke-story";

	}
	@RequestMapping("/tripplanner")
	public String tripPlanner(Model model) {
		logger.info("home resource tripPlanner page info");
		logger.debug("home resource tripPlanner page debugging");
		model.addAttribute("forgotPassword", new RegisterUser());
		return "trip-planner-story";

	}
}
