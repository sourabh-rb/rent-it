package com.rentit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentit.model.Vehicles;
import com.rentit.model.vehicleService;

@Controller
public class vehicleController {

	@Autowired
	private vehicleService vehicleService;

	@RequestMapping("/vehicle")
	public String listClient(Model model) {

		List<Vehicles> listVehicles = vehicleService.listAll();
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}

	// @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	@PostMapping("/vehicle")
	public String getDetail(@ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes, Model model) {
		List<Vehicles> listVehicles = vehicleService.listAll();
		String sMake = VehiclesAttributes.getMake();
		String sType = VehiclesAttributes.getType();
		String sModel = VehiclesAttributes.getModel();
		String sYear = VehiclesAttributes.getiYear();
		int iSize = listVehicles.size();
		if (!(iSize == 0) || !(listVehicles.equals(null))) {

			listVehicles = vehicleService.ListAllSearches(sMake.trim(), sType.trim(), sModel.trim(), sYear.trim());

		}
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}
	/*
	 * @PostMapping("/vehicle") public String
	 * SortBaseOnCondition(@ModelAttribute(name = "${vehicleform}") Vehicles
	 * VehiclesAttributes, Model model) { String sColHeaderPressed="Make"; String
	 * sOrder="ASC"; List<Vehicles> listVehicles =
	 * vehicleService.sortListBasedOnCodn(sColHeaderPressed,sOrder);
	 * model.addAttribute("vehicle", listVehicles); return "vehicle"; }
	 */
}