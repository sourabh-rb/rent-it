package com.rentit.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentit.model.Vehicles;
import com.rentit.model.vehicleService;

@Controller
public class vehicleController {

	private static String sOrderMake="ASC";
	private static String sOrderModel="ASC";
	private static String sOrderYear="ASC";
	private static String sOrderType="ASC";
	
	
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
			// Collections.sort(listVehicles,(o1, o2) ->
			// o1.getMake().compareTo(o2.getMake()));

		}
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}

	@RequestMapping(value = "/vehicle", params = "btnSortMake", method = RequestMethod.POST)
	public String btnSortMake(Model model) {
		
		List<Vehicles> listVehicles = vehicleService.listAll();
		if(sOrderMake.equals("DESC")) {
			Collections.sort(listVehicles, (o1, o2) -> o1.getMake().compareTo(o2.getMake()));
			sOrderMake="ASC";
		}
		else if(sOrderMake.equals("ASC"))
		{
			Collections.sort(listVehicles, (o1, o2) -> o2.getMake().compareTo(o1.getMake()));
			sOrderMake="DESC";
		}
		
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}
	
	@RequestMapping(value = "/vehicle", params = "btnSortModel", method = RequestMethod.POST)
	public String btnSortModel(Model model) {
		
		List<Vehicles> listVehicles = vehicleService.listAll();
		if(sOrderModel.equals("DESC")) {
			Collections.sort(listVehicles, (o1, o2) -> o1.getModel().compareTo(o2.getModel()));
			sOrderModel="ASC";
		}
		else if(sOrderModel.equals("ASC"))
		{
			Collections.sort(listVehicles, (o1, o2) -> o2.getModel().compareTo(o1.getModel()));
			sOrderModel="DESC";
		}
		
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}
	
	@RequestMapping(value = "/vehicle", params = "btnSortYear", method = RequestMethod.POST)
	public String btnSortyear(Model model) {
		
		List<Vehicles> listVehicles = vehicleService.listAll();
		if(sOrderYear.equals("DESC")) {
			Collections.sort(listVehicles, (o1, o2) -> o1.getiYear().compareTo(o2.getiYear()));
			sOrderYear="ASC";
		}
		else if(sOrderYear.equals("ASC"))
		{
			Collections.sort(listVehicles, (o1, o2) -> o2.getiYear().compareTo(o1.getiYear()));
			sOrderYear="DESC";
		}
		
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}
	
	

	@RequestMapping(value = "/vehicle", params = "btnSortVechicles", method = RequestMethod.POST)
	public String btnSortType(Model model) {
		
		List<Vehicles> listVehicles = vehicleService.listAll();
		if(sOrderType.equals("DESC")) {
			Collections.sort(listVehicles, (o1, o2) -> o1.getType().compareTo(o2.getType()));
			sOrderType="ASC";
		}
		else if(sOrderType.equals("ASC"))
		{
			Collections.sort(listVehicles, (o1, o2) -> o2.getType().compareTo(o1.getType()));
			sOrderType="DESC";
		}
		
		model.addAttribute("vehicle", listVehicles);
		return "vehicle";

	}

}