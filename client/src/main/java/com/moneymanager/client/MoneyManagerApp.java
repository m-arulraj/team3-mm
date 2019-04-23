package com.moneymanager.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MoneyManagerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(MoneyManagerApp.class, args);
    }
    
    @Bean
    public RestTemplate getRestTemplate() {
    	return new RestTemplate();
    }
}
