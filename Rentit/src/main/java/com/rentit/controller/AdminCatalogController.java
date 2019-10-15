
package com.rentit.controller;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;

@Controller
public class AdminCatalogController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/admin")
	public String listloadVehicle(Model model) {
		ModelWrapper listVehicles= vehicleService.listAll();
		//System.out.println(listVehicles);
		model.addAttribute("admin", listVehicles);
		return "admin";
	}
	
	
	@RequestMapping(value = "/admin", params = "btnedit", method = RequestMethod.POST)
	public String btnEdit(Model model) {
		
		
		
		return "redirect:/addEditAdmin";

	}
	
	@RequestMapping(value = "/admin", params = "btnDelete", method = RequestMethod.POST)
	public String btnDelete(Model model) {
		
		
		
		return "redirect:/addEditAdmin";

	}
	
	
	
	
	
}
