package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Clerks;
import com.rentit.model.Login;
import com.rentit.model.Register;


@Controller
public class RegisterController {

//	@RequestMapping("/register", method = RequestMethod.GET)
//	public ModelAndView getUserDetails() {
//		ModelAndView model = new  ModelAndView("register");
//		 Register obj = new Register();
//		 model.addObject("register", obj);
//		return model;
//		 
//	}
	
	
	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		Clerks newClerk = new Clerks();
		model.addAttribute("clerk", newClerk);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
     public String getDetail(@ModelAttribute("register") Register register) {
             Login login = new Login();
			login.addCredentials(register.getUSername(), register.getPassword());
			 return "redirect:/login"; 
	}
	
}
