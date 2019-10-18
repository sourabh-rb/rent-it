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

import com.rentit.model.Bookings;
import com.rentit.model.Clients;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * This class handles booking functionalities.
 * 
 * @author Sourabh Rajeev Badagandi , Anusha
 *
 */
@Controller
public class BookinFormController {

	static LocalDate localDate = LocalDate.now();
	String currentdate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
	Date currentdate1 = null;
	Date startdate1 = null;
	Date duedate1 = null;
	Date licenseexpiry1 = null;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	private ClientsService clientService;

	/**
	 * This method renders booking page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bookingForm")
	public String bookingDetails(Model model) {

		model.addAttribute("bookingn", new ModelWrapper());

		return "bookingForm";

	}

	/**
	 * This method confirms booking upon validation.
	 * 
	 * @param newBooking
	 * @param model
	 * @param startDate
	 * @param dueDate
	 * @param licenceValidity
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String getDetail(@ModelAttribute("bookingn") ModelWrapper newBooking,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "dueDate", required = false) String dueDate,
			@RequestParam(value = "licenceValidity", required = false) String licenceValidity,
			Model model) {
		boolean  valid = false;
		try {
			currentdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);
			startdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			duedate1 = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
			licenseexpiry1 = new SimpleDateFormat("yyyy-MM-dd").parse(licenceValidity);

		} catch (ParseException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (startdate1.after(currentdate1)
				|| startdate1.equals(currentdate1) && duedate1.after(startdate1) && licenseexpiry1.after(duedate1)) {
			  valid = true;
		} 
		
		if (startdate1.before(currentdate1)) {   
			valid = false;
		} 
		if (duedate1.before(startdate1)) {   
			valid = false;
			
		} 
		 if (licenseexpiry1.before(duedate1)) { 
			 valid = false;
			

		}
		 
		if(valid == false){
		    	model.addAttribute("startDate", true);
		    	return "bookingForm";
		    }
		    else {
		    	clientService.saveNewBooking(newBooking); 
		    	return "redirect:/clients";
		    }
		 

		
	}

}