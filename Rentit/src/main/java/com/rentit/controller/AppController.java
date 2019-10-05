package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
	    return "index";
	}
	
//	@RequestMapping("/index")
//	public String viewHomePage(Model model) {
//	    return "index";
//	}

}
