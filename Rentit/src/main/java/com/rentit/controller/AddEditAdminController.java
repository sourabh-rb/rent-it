package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddEditAdminController {

	
	
	@RequestMapping("/addEditAdmin")
	public String AddEditVehicle(Model model) {
		//ModelWrapper listVehicles= vehicleService.listAll();
		//System.out.println(listVehicles);
		//model.addAttribute("addEditAdmin", listVehicles);
		return "addEditAdmin";
	}
}
