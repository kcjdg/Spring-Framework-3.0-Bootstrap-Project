package com.ph.sinonet.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph.sinonet.spring.service.interfaces.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService service;
	
	
	
	@RequestMapping("/login")
	public String helloPage(){
		return "login";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied(){
		return "denied";
	}
	
	
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	
	
	
}
