package com.ph.sinonet.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph.sinonet.spring.dto.PersonDto;
import com.ph.sinonet.spring.model.entity.User;
import com.ph.sinonet.spring.service.interfaces.UserService;



@Controller
@RequestMapping("/spring/")
public class HelloWorldController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/success")
	public String helloWorld(Model model){
		PersonDto dto = new PersonDto();
		dto.setEntryDate(new Date());
		model.addAttribute("time", dto.getEntryDate());
		return "success";
	}

	
	
}
