package com.virtusa.money.manager.user.service.logging;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	Logger log = Logger.getLogger(LoggingAspect.class);
	@Before("execution(* com.virtusa.money.manager.user.service.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		log.info("Before Method execution Class :- "+joinPoint.getTarget().getClass()+" - Method :- "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.virtusa.money.manager.user.service.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		log.info("After Method execution Class :- "+joinPoint.getTarget().getClass()+" - Method :- "+joinPoint.getSignature().getName());
	}
}
