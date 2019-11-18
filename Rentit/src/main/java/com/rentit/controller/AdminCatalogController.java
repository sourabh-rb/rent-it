
package com.rentit.controller;

import java.text.ParseException;
import java.util.List;
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
import com.rentit.model.AdminDataMapper;
import com.rentit.model.ClerksDataMapper;
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
  static int count = 0;
  RegisterController rv = new RegisterController();
  @Autowired
  private VehicleService vehicleService;
  private AdminDataMapper adminDataMapper;
  List<Vehicles> VehiclesList = null;

  /**
   * This method renders Vehicle catalog page.
   * 
   * @param model
   * @return
   */
  @RequestMapping("/admin")
  public String loadVehicleList(Model model, HttpSession session) {

    String username = (String) session.getAttribute("sessionusername");
    String usergroup = (String) session.getAttribute("sessionusergroup");
    session.setAttribute("mySessionAttribute1", username);
   count =0;
    if (username != null && usergroup .equals("admin")) {
      adminDataMapper= new AdminDataMapper();
      VehiclesList =adminDataMapper.getVehiclesData();
      model.addAttribute("vehicle", VehiclesList);
  
      return "admin";
    } else if (username != null && usergroup.equals("clerk")) {
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
  public String fncSearchAddedVehicle(
      @ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes, Model model,
      @RequestParam(value = "checkboxName", required = false) String checkboxValue,
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
    adminDataMapper= new AdminDataMapper();
    VehiclesList = adminDataMapper.getVehiclesDataViaSearch(sMake.trim(), sType.trim(),
        sModel.trim(), sYear.trim(), checkboxValue.trim(), checkboxValue1.trim());

    model.addAttribute("vehicle", VehiclesList);
    return "admin";

  }

  /**
   * This method allows an admin to add a new vehicle from main admin page.
   * 
   * @param model
   * @return an empty vehicle
   */

  @RequestMapping(value = "/admin", params = "btnAdd", method = RequestMethod.POST)
  public ModelAndView addVehicleRecord(Model model, HttpSession session) {
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
   * @throws ParseException
   */

  @RequestMapping(value = "/addEditAdmin", params = "btnUpdate", method = RequestMethod.POST)
  public String updateVehicleRecord(@ModelAttribute("vehicleForEdit") Vehicles vehicleDetails,HttpSession session)
      throws ParseException {
    
    try {
      if (vehicleDetails.getId() == 0) {
        adminDataMapper.addVehiclesRecord(vehicleDetails);
      } else {
        long vid = vehicleDetails.getId();
        Long version1 = (long) adminDataMapper.getVehicleVersion(vid);
        adminDataMapper.updateVehiclesRecord(vehicleDetails, version1);
        count = 0;
      }
    } catch (Exception e) {
      e.printStackTrace();
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
    count = 1;
    long version = (long) adminDataMapper.getVehicleVersion(id);
    adminDataMapper.updateVersion(id, version);
    String actionString = "edit";
    session.setAttribute("sessionButtonAttribute", actionString);

    ModelAndView sDetailsmav = new ModelAndView("addEditAdmin");
    Vehicles VechilesDetails=adminDataMapper.getRecord(id);
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
  public String deleteVehicleRecord(@PathVariable(name = "id") int id) {
    adminDataMapper.removeVehiclesRecord(id);

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

  @RequestMapping(value = "/admin", params = "logout", method = RequestMethod.POST)
  public String logout(Model model) {
    ClerksDataMapper.resetAdminLogin();
    return "redirect:/loginpage";
  }

}
