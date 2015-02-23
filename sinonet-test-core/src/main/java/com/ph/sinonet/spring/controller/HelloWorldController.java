package com.ph.sinonet.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph.sinonet.spring.dto.PersonDto;



@Controller
@RequestMapping("/spring/")
public class HelloWorldController {
	
	
	@RequestMapping("/success")
	public String helloWorld(Model model){
		PersonDto dto = new PersonDto();
		dto.setEntryDate(new Date());
		model.addAttribute("time", dto.getEntryDate());
		return "success";
	}

	
	
}
