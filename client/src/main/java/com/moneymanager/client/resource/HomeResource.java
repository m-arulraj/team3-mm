package com.moneymanager.client.resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moneymanager.client.MoneyManagerApp;

@Controller
public class HomeResource {
	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);
	
	@RequestMapping(value="/re",method=RequestMethod.GET)
	public String home()
	{
		logger.info("home resource");
		logger.debug("test");
		return "report";
		
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "user-login";
		
	}

	@RequestMapping("/registration")
	public String registration()
	{
		return "user-registration";
		
	}
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
		
	}
	@RequestMapping("/test")
	public String test()
	{
		return "report";
		
	}
}
