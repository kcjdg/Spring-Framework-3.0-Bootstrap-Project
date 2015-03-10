package com.ph.sinonet.spring.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogger {
	

	@Pointcut("within(com.ph.sinonet.spring.service.interfaces.*+))")
	public void servicesAdvice(){}
	
	
	@Pointcut("!execution(* get*(..)) && !execution(* search*(..)) && !execution(* load*(..)) && !execution(* find*(..))")
	public void excludedMethods(){}
	
	
	@Before("servicesAdvice() && excludedMethods()")
	public void checkUserAuthentication(JoinPoint jp){
		Object target = jp.getTarget();
		Authentication auth = getCurrentAuth();
		if(isAuthenticated(auth)){
			Logger logger = LoggerFactory.getLogger(target.getClass());
			logger.debug("Method hit : {} , Username :  {}", jp.getSignature().getName(), auth.getName());
		}
	}


	private Authentication getCurrentAuth(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	
	private boolean isAuthenticated(Authentication auth){
		return (auth == null) ? false : auth.isAuthenticated();
	}

}
