
package com.rentit.controller;

import javax.servlet.http.HttpSession;
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
 * 
 * @author Basant Gera
 *
 */
@Controller
public class AdminCatalogController {
  RegisterController rv = new RegisterController();
  @Autowired
  private VehicleService vehicleService;

  /**
   * This method renders Vehicle catalog page.
   * 
   * @param model
   * @return
   */
  @RequestMapping("/admin")
  public String listloadVehicle(Model model, HttpSession session) {
    String username = LoginController.username;
    String usergroup = LoginController.usergroup;
    if (username != null && usergroup == "admin") {
      ModelWrapper listVehicles = vehicleService.listAll();
      model.addAttribute("vehicle", listVehicles);
      return "admin";
    } else if (username != null && usergroup == "clerk") {
      return "redirect:/vehicle";
    } else
      return "redirect:/loginpage";
  }

  /**
   * This method redirects to get detail page.
   * 
   * @param VehiclesAttributes
   * @param model
   * @return
   */
  @PostMapping("/admin")
  public String getDetail(@ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes,
      Model model, @RequestParam(value = "checkboxName", required = false) String checkboxValue,
      @RequestParam(value = "checkboxName1", required = false) String checkboxValue1) {
    ModelWrapper listVehicles = vehicleService.listAll();

    if (checkboxValue != null) {
      checkboxValue = "True";
    } else {
      checkboxValue = "False";
    }

    if (checkboxValue1 != null) {
      checkboxValue1 = "True";
    } else {
      checkboxValue1 = "False";
    }

    String sMake = VehiclesAttributes.getMake();
    String sType = VehiclesAttributes.getType();
    String sModel = VehiclesAttributes.getModel();
    String sYear = VehiclesAttributes.getiYear();
    int iSize = listVehicles.getCatalogList().size();
    if (!(iSize == 0) || !(listVehicles.equals(null))) {

      listVehicles = vehicleService.ListAllSearches(sMake.trim(), sType.trim(), sModel.trim(),
          sYear.trim(), checkboxValue.trim(), checkboxValue1.trim());
    }
    model.addAttribute("vehicle", listVehicles);
    return "admin";

  }

  /**
   * This method allows an admin to add a new vehicle from main admin page.
   * 
   * @param model
   * @return an empty vehicle
   */

  @RequestMapping(value = "/admin", params = "btnAdd", method = RequestMethod.POST)
  public ModelAndView btnAdd(Model model, HttpSession session) {
    String actionString = "add";
    session.setAttribute("sessionButtonAttribute", actionString);

    ModelAndView addVehicle = new ModelAndView("addEditAdmin");
    addVehicle.addObject("vehicleForEdit", new Vehicles());
    return addVehicle;

  }

  /**
   * This method is used to add a new vehicle or update existing vehicle details in admin page.
   * 
   * @param vehicleDetails
   * @return redirect to admin page after action is complete
   */

  @RequestMapping(value = "/addEditAdmin", params = "btnUpdate", method = RequestMethod.POST)
  public String updateEdit(@ModelAttribute("vehicleForEdit") Vehicles vehicleDetails) {

    if (vehicleDetails.getId() == 0) {
      vehicleService.AddVehicleInfo(vehicleDetails);
    } else {
      vehicleService.UpdateVehicleInfo(vehicleDetails);
    }
    return "redirect:/admin";
  }

  /**
   * This method is used to populate vehicle details in addEditAdmin page
   * 
   * @param model
   * @return redirect to addEditAdmin page
   */
  @RequestMapping(value = "/admin/{id}", params = "btnedit", method = RequestMethod.POST)
  public String btnEdit(Model model) {

    ModelWrapper listVehicles = vehicleService.listAll();
    model.addAttribute("vehicle", listVehicles);
    return "redirect:/addEditAdmin";

  }

  /**
   * Method used to redirect to addEditAdmin page on click of edit in admin page.
   * 
   * @param id
   * @param model
   * @return addEditAdmin page
   */

  @RequestMapping("/addEditAdminPage/{id}")
  public ModelAndView btnGetIdtoDetailedView(@PathVariable(name = "id") Long id, Model model,
      HttpSession session) {

    String actionString = "edit";
    session.setAttribute("sessionButtonAttribute", actionString);

    ModelAndView sDetailsmav = new ModelAndView("addEditAdmin");
    Vehicles VechilesDetails = vehicleService.getVechileInfo((id));
    sDetailsmav.addObject("vehicleForEdit", VechilesDetails);
    return sDetailsmav;
  }

  /**
   * This method is used to delete a vehicle in admin page, based on its ID.
   * 
   * @param id
   * @return redirect to admin page after delete
   */
  @RequestMapping("/delete/{id}")
  public String deleteVehicle(@PathVariable(name = "id") int id) {
    vehicleService.deleteVehicle(id);
    return "redirect:/admin";
  }

  /**
   * This method is used to redirect to transactions page.
   * 
   * @param model
   * @return redirect to transactions page.
   */

  @RequestMapping(value = "/admin", params = "btnManageTransactions", method = RequestMethod.POST)
  public String btnManageTransactions(Model model) {

    return "redirect:/transactions";

  }

}
