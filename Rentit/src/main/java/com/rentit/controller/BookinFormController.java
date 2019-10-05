package com.rentit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentit.model.Clients;
import com.rentit.model.bookingForm;
import com.rentit.model.registerform;

@Controller
public class BookinFormController {
	 
	@RequestMapping(value = "/bookingForm")
	public String bookingDetails(Model model) {
		//model.addAttribute("bookingForm", new bookingForm());
       
				return "bookingForm";
		 
	}
	
	@RequestMapping(value = "/bookingForm", method = RequestMethod.POST)
	public String getDetail(@ModelAttribute(name = "bookingForm") bookingForm bookingForm, Model model) {

		String firstname = bookingForm.getFirstname();
		String lastname = bookingForm.getLastname();
		String licensenumber = bookingForm.getlicensenumber();
		String expiredate = bookingForm.getexpiredate();
		String emailid = bookingForm.getemailid();
		String phoneno = bookingForm.getphoneno();
		String startdate= bookingForm.getstartdate();
		String returndate= bookingForm.getreturndate();
	
		
		return "redirect:/clients";
		
		
		 
	}
	 
	    
}



