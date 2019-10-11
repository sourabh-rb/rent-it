package com.rentit.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	
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
	public String getDetail(@Valid @ModelAttribute("bookingn") ModelWrapper newBooking, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//System.out.println("BINDING RESULT ERROR");
			return "bookingForm";
		}
		
		else {
		clientService.saveNewBooking(newBooking);
		
		return "redirect:/clients";
		
		}
		 
	}
	 
	    
}



