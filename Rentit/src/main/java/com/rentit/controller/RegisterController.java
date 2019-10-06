package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Login;
import com.rentit.model.Register;


@Controller
public class RegisterController {

	@RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
	public ModelAndView getUserDetails() {
		ModelAndView model = new  ModelAndView("registrationpage");
		 Register obj = new Register();
		 model.addObject("register", obj);
		return model;
		 
	}
	
	@RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
     public String getDetail(@ModelAttribute("register") Register register,Model model) {
             Login login = new Login();
             if(!register.getUSername().isEmpty()) {
			if(login.addCredentials(register.getUSername(), register.getPassword())) {
			 return "redirect:/loginpage"; 
			}
			else {
				model.addAttribute("userexits",true);
				return "registrationpage";
			}
             }
             else {
            	 model.addAttribute("filldetails",true);
            	 return "registrationpage";
             }
			 
	}
	
}
