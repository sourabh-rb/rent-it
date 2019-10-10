package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Clerks;
import com.rentit.model.ClerksService;
import com.rentit.model.Login;
import com.rentit.model.Register;

/**
 * This class control the viewpage and model of registration
 * @author charan
 *
 */
@Controller
public class RegisterController {
    /**
     * This method is to pass the data to registration page
     * @return model data
     */
	@RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
	public ModelAndView getUserDetails() {
		ModelAndView model = new  ModelAndView("registrationpage");
		 Clerks obj = new Clerks();
		 model.addObject("Clerks", obj);
		return model;
		 
	}
	
	/**
	 * This methos is to get details from the view
	 * @param register is a object which stores the view data
	 * @param model is model data
	 * @return view page or view name to redirect
	 */
	@RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
     public String getDetail(@ModelAttribute("clerks") Clerks clerks,Model model) {
            // Login login = new Login();
            // if(!register.getUSername().isEmpty()) {
			//if(login.addCredentials(register.getUSername(), register.getPassword())) {
		String firstname = clerks.getFirstName();
		String lastname = clerks.getLastName();
		String username = clerks.getUsername();
		String password = clerks.getPassword();
		String emailid = clerks.getEmail();
		ClerksService clerkdata = new ClerksService();
		clerkdata.addClerks(clerks);
			 return "redirect:/loginpage"; 
			 
//			}
//			else {
//				model.addAttribute("userexits",true);
//				return "registrationpage";
//			}
//             }
//             else {
//            	 model.addAttribute("filldetails",true);
//            	 return "registrationpage";
//             }
			 
	}
	
}
