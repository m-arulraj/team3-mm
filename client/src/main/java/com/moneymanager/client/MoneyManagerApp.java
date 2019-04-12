package com.moneymanager.client;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyManagerApp {
	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/logger.properties");
		
		SpringApplication.run(MoneyManagerApp.class, args);
	}
}
