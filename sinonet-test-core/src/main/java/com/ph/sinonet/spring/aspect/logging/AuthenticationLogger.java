package com.ph.sinonet.spring.aspect.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ph.sinonet.spring.model.entity.User;
import com.ph.sinonet.spring.service.interfaces.UserService;

/**
 * Use if interface
 * execution(* org.springframework.security.core.Authentication+.*(..)
 * + = all implements this interface
 * 
 * @author sinonet
 *
 */

@Aspect		
public class AuthenticationLogger {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationLogger.class);

	@Autowired
	private HttpServletRequest request;
	
	@Autowired 
	private UserService userService;
	
	
	@Pointcut("execution(* org.springframework.security.authentication.AuthenticationProvider+.*(..))")
	public void loginAdvice(){}
	
	
	@Pointcut("execution(* org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler.logout(..)) && args (request,response,authentication)")
	public void logoutAdvice(HttpServletRequest request,HttpServletResponse response, Authentication authentication){}
	
	
	
	@AfterReturning(pointcut="loginAdvice()",returning="authentication")
	public void checkAfterLogin(Authentication authentication){
		if(authentication.isAuthenticated()){
			String ip = request.getRemoteAddr();
			LOGGER.info("User {} is authenticated with role {} and ip of {}", authentication.getName(), authentication.getAuthorities(), ip);
			User user = userService.getUser(authentication.getName());
			userService.updateLastVisit(user, ip);
		}
	}
	
	@After("logoutAdvice(request,response,authentication)")
	public void checkAfterLogout(JoinPoint jp,HttpServletRequest request,HttpServletResponse response, Authentication authentication){
		SecurityContext context = SecurityContextHolder.getContext();
		if(context.getAuthentication() == null && authentication != null){
			LOGGER.info("User {} is successfully logout " , authentication.getName());
		}
	}

	
}