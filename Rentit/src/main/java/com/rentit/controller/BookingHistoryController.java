package com.rentit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentit.model.BookingService;
import com.rentit.model.ModelWrapper;

/**
 * BookingHistory Controller is used to render booking manager.
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
@Controller
public class BookingHistoryController {
	
	@Autowired
	private BookingService bookingService;
	
	/**
	 * 
	 * This method is used to render booking manager view.
	 * @param model : model to hold attributes of bookings
	 * @return booking-manager : booking manager view
	 */
	@RequestMapping("/transactions")
	public String listClient(Model model) {
		
		List<ModelWrapper> listBookings = bookingService.listAll();
		model.addAttribute("bookings", listBookings);
		return "booking-manager";
	}

}
