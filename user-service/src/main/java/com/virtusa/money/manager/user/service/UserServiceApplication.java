package com.virtusa.money.manager.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserServiceApplication 
{
    public static void main( String[] args )
    {
    	
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
