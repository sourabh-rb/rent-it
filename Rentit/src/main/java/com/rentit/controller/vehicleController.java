package com.rentit.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Vehicles;
import com.rentit.model.vehicleService;

@Controller
public class vehicleController {

	//List<Vehicles> vehiclesItems = new ArrayList<Vehicles>();

		@Autowired
		private vehicleService vehicleService;
		
		@RequestMapping("/vehicle")
		public String listClient(Model model) {
		
        List<Vehicles> listVehicles = vehicleService.listAll();
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";
			
	}
	
	
	
}