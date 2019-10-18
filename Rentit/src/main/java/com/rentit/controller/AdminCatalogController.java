
package com.rentit.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;
import com.rentit.model.Vehicles;


/**
 * This class handles vehicle catalog for add/delete/ Modify functionality and view transaction too.
 * @author Basant Gera
 *
 */
@Controller
public class AdminCatalogController {
	
	@Autowired
	private VehicleService vehicleService;
	
	/**
	 * This method renders  Vehicle catalog page.
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin")
	public String listloadVehicle(Model model) {
		ModelWrapper listVehicles= vehicleService.listAll();
		model.addAttribute("vehicle", listVehicles);
		return "admin";
	}
	
	
	/**
	 * This method redirects to get detail page.
	 * @param VehiclesAttributes
	 * @param model
	 * @return
	 */
	@PostMapping("/admin")
	public String getDetail(@ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes, Model model,@RequestParam(value = "checkboxName", required = false) String checkboxValue,@RequestParam(value = "checkboxName1", required = false) String checkboxValue1) {
		ModelWrapper listVehicles = vehicleService.listAll();
		
		if(checkboxValue!= null)
		  {
			checkboxValue="True";
		  }
		else {
			checkboxValue="False";
		}
		
		
		if(checkboxValue1!= null)
		  {
			checkboxValue1="True";
		  }
		else {
			checkboxValue1="False";
		}
		
		String sMake = VehiclesAttributes.getMake();
		String sType = VehiclesAttributes.getType();
		String sModel = VehiclesAttributes.getModel();
		String sYear = VehiclesAttributes.getiYear();
		String sColor=VehiclesAttributes.getColor();
		String sLicPlate=VehiclesAttributes.getLicPlate();
		int iSize = listVehicles.getCatalogList().size();
		if (!(iSize == 0) || !(listVehicles.equals(null))) {

			listVehicles = vehicleService.ListAllSearches(sMake.trim(), sType.trim(), sModel.trim(), sYear.trim(),checkboxValue.trim(),checkboxValue1.trim());
		}
		model.addAttribute("vehicle", listVehicles);
		return "admin";

	}
	
	@RequestMapping(value = "/admin", params = "btnAdd", method = RequestMethod.POST)
	public ModelAndView btnAdd(Model model) {
		ModelAndView addVehicle = new ModelAndView("addEditAdmin");
		addVehicle.addObject("vehicleForEdit", new Vehicles());
		   return addVehicle;



	//	return "redirect:/addEditAdmin";

	}
	
	@RequestMapping(value = "/addEditAdmin", params = "btnUpdate" , method = RequestMethod.POST)
	public String updateEdit(@ModelAttribute("vehicleForEdit") Vehicles vehicleDetails) {
		
		if(vehicleDetails.getId()==0) 
		{
		vehicleService.AddVehicleInfo(vehicleDetails);	
		}
		else 
		{
		vehicleService.UpdateVehicleInfo(vehicleDetails);
		}
	    return "redirect:/admin";
	}
	
	
	@RequestMapping(value = "/addEditAdmin", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes) {
		ModelWrapper listVehicles = vehicleService.listAll();
		String sMake = VehiclesAttributes.getMake();
		String sType = VehiclesAttributes.getType();
		String sModel = VehiclesAttributes.getModel();
		String sYear = VehiclesAttributes.getiYear();
		String sColor=VehiclesAttributes.getColor();
		String sLicPlate=VehiclesAttributes.getLicPlate();
		int iSize = listVehicles.getCatalogList().size();
		
		 if((sMake.equals("")||sMake.equals(null)) && (sModel.equals("")||sModel.equals(null)) && (sYear.equals("")||sYear.equals(null)) && (sType.equals("")||sType.equals(null)) && (sColor.equals("")||sColor.equals(null)) && (sLicPlate.equals("")||sLicPlate.equals(null))) {
			 System.out.print("EnterIN");
		 }
		 else
		 {
			 if (!(iSize == 0) || !(listVehicles.equals(null))) {

					listVehicles = vehicleService.fncadditem(VehiclesAttributes,iSize);
				}
		 }
		
		
		return "redirect:/admin";
	}
	


	@RequestMapping(value = "/admin/{id}", params = "btnedit", method = RequestMethod.POST)
	public String btnEdit(Model model) {
		
		// handover to Arvind
		ModelWrapper listVehicles= vehicleService.listAll();
		model.addAttribute("vehicle", listVehicles);
		return "redirect:/addEditAdmin";

	}
	
	/**
	 * Method used to redirect to addEditAdmin page on click of edit in admin page.
	 * @param id
	 * @param model
	 * @return addEditAdmin page
	 */ 
	
	@RequestMapping("/addEditAdminPage/{id}")
	public ModelAndView btnGetIdtoDetailedView(@PathVariable(name = "id") Long id,Model model) {
	 ModelAndView sDetailsmav = new ModelAndView("addEditAdmin");
	    Vehicles VechilesDetails = vehicleService.getVechileInfo((id));
	    sDetailsmav.addObject("vehicleForEdit", VechilesDetails);
	    return sDetailsmav;
}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable(name = "id") int id) {
	    vehicleService.deleteVehicle(id);
	    return "redirect:/admin";       
	}
	
	@RequestMapping(value = "/admin", params = "btnDelete", method = RequestMethod.POST)
	public String btnDelete(Model model) {
		// handover to Koti
		
		return "redirect:/addEditAdmin";

	}
	
	
	@RequestMapping(value = "/admin", params = "btnManageTransactions", method = RequestMethod.POST)
	public String btnManageTransactions(Model model) {
		
		return "redirect:/transactions";

	}
	
}
