package com.rentit.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.rentit.model.Login;
import com.rentit.model.registerform;


@Controller
public class RegisterController {
	

	@RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
	public String getUserDetails() {
		 ModelAndView model = new  ModelAndView("registrationpage");
		 registerform obj = new registerform();
		 model.addObject("register", obj);
		return "/registrationpage";
		 
	}
	
	@RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
	public String getDetail(@ModelAttribute(name = "${registerform}") registerform registerform, Model model ) {

		Login login = new Login();
		String un = registerform.getUSername();
		
		login.addCredentials(registerform.getUSername(), registerform.getPassword());
		 return "redirect:/LoginPage";
		
	}
	
}
