package com.moneymanager.client.resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymanager.client.MoneyManagerApp;

@Controller
public class HomeResource {
	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	@RequestMapping("/")
	public String index() {
		logger.info("home resource index page info");
		logger.debug("home resource index page debugging");
		return "index";
	}

	@RequestMapping("/user-login")
	public String login() {

		logger.info("home resource user-login page info");
		logger.debug("home resource user-login page debugging");

		return "user-login";

	}

	@RequestMapping("/user-registration")
	public String registration() {

		logger.info("home resource user-registration page info");
		logger.debug("home resource user-registration page debugging");

		return "user-registration";

	}

	@RequestMapping("/welcome")
	public String welcome() {

		logger.info("home resource user-welcome page info");
		logger.debug("home resource user-welcome page debugging");

		return "welcome";

	}

	@RequestMapping("/user-report")
	public String reports() {

		logger.info("home resource user-repot page info");
		logger.debug("home resource user-repot page debugging");

		return "report";

	}
}
