package com.rentit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentit.model.Clients;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;

/**
 * This class handles booking functionalities.
 * @author Sourabh Rajeev Badagandi
 *
 */
@Controller
public class BookinFormController {
	
	@Autowired
	private ClientsService clientService;
	 
	/**
	 * This method renders booking page.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bookingForm")
	public String bookingDetails(Model model) {
		
		model.addAttribute("bookingn", new ModelWrapper());
       
				return "bookingForm";
		 
	}
	
	/**
	 * This method confirms booking.
	 * @param newBooking
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String getDetail(@ModelAttribute("bookingn") ModelWrapper newBooking, Model model) {

		
		clientService.saveNewBooking(newBooking);
		
		return "redirect:/clients";
		
		
		 
	}
	 
	    
}



