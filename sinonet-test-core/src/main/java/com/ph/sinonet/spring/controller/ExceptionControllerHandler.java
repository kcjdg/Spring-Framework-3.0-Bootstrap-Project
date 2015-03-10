package com.ph.sinonet.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionControllerHandler {

	public static final String DEFAULT_ERROR_VIEW = "500";

	@ExceptionHandler(Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		ModelAndView systemError = new ModelAndView(DEFAULT_ERROR_VIEW);
		systemError.addObject("datetime",new Date());
		systemError.addObject("exception",e);
		systemError.addObject("url",request.getRequestURI());
		return systemError;
	}
	
}
