package com.ph.sinonet.spring.aspect.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Use if interface
 * execution(* org.springframework.security.core.Authentication+.*(..)
 * + = all implements this interface
 * 
 * @author sinonet
 *
 */

@Aspect
public class AuthenticatedUserLogger {

	private boolean isAuthUser = false;
	private String authUsername; 
	
	@Pointcut("execution(* javax.servlet.http.HttpServlet.service(..)) && "+
			"args(request,response)")
	public void checkServletRequest(HttpServletRequest request,HttpServletResponse response){}


	@Pointcut("within(com.ph.sinonet.spring.service.interfaces.*+))")
	public void allServices(){}
	
	
	@Pointcut("execution(* org.springframework.security.core.userdetails.UserDetailsService+.*(..))")
	public void checkAuthUser(){}
	
	
	
	@AfterReturning(pointcut="checkAuthUser()",returning="userDetails")
	public void checkAfterLogin(UserDetails userDetails){
		if(!userDetails.getAuthorities().isEmpty()){
			isAuthUser = true;
			authUsername = userDetails.getUsername();
		}
	}

	@Around(value= "allServices()")
	public Object aroundAService(ProceedingJoinPoint jp) throws Throwable{
		Object target = jp.getTarget();
		Logger logger = LoggerFactory.getLogger(target.getClass());
		
		Object returnVal = jp.proceed(jp.getArgs());
		
		if(isAuthUser){
			logger.info("Method hit : {} , Username :  {}, Args : {}, Result : {}", jp.getSignature().getName(), authUsername, jp.getArgs(),returnVal);
		}
		return returnVal;
	}

	

	public String getAuthUsername() {
		return authUsername;
	}


	public void setAuthUsername(String authUsername) {
		this.authUsername = authUsername;
	}

}