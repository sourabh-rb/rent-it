package com.rentit.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Clients;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;

@Controller
//@RequestMapping("/")
public class ClientsController {
	
	@Autowired
	private ClientsService clientService;
	
	@RequestMapping("/clients")
	public String listClient(Model model) {
		
		List<ModelWrapper> listClient = clientService.listAll();
		model.addAttribute("clients", listClient);
		return "client-manager";
	}
	
	
	@RequestMapping("/return/{id}")
	public String returnVehicle(@PathVariable(name = "id") Long id) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		clientService.setReturnDate(id, dtf.format(now));
	    return "redirect:/clients";       
	}
	
	@RequestMapping("/cancel/{id}")
	public String cancelBooking(@PathVariable(name = "id") Long id) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		clientService.setCancelDate(id, dtf.format(now));
	    return "redirect:/clients";       
	}
	
	@RequestMapping("/modify/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("client-modify");
	    Clients clientDetails = clientService.getClientInfo(id);
	    mav.addObject("modify", clientDetails);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("modify") Clients clientDetails) {
		
		clientService.saveClientInfo(clientDetails);
	     
	    return "redirect:/clients";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancelEdit(@ModelAttribute("modify") Clients clientDetails) {
		 
	    return "redirect:/clients";
	}
	
	


}
