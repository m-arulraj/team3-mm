package com.moneymanager.client.resource;

import org.springframework.stereotype.Controller;

@Controller
public class ErrorPage implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "404";
	}

}
