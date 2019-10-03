package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.registerform;


@Controller
public class RegisterController {

	@RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
	public String getUserDetails() {
		// ModelAndView model = new  ModelAndView("registrationpage");
		 
		return "registrationpage";
		 
	}
	
	@RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
	public String getDetail(@ModelAttribute(name = "registerform") registerform registerform, Model model) {
//		 ModelAndView model = new  ModelAndView("registrationpage");
		String firstname = registerform.getFirstname();
		String lastname = registerform.getLastname();
		String username = registerform.getUSername();
		String password = registerform.getPassword();
		String emailid = registerform.getEmailid();
		String clerkid = registerform.getClerkId();
	
		
		 return "LoginPage";
		//System.out.println(firstname);
		
		 
	}
	
}
