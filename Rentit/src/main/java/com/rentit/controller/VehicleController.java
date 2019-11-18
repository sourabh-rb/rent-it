package com.rentit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rentit.model.Vehicles;
import com.rentit.model.VehiclesDataMapper;
import com.rentit.data_source.VehiclesDataGateway;
import com.rentit.model.ClerksDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;

/**
 * This class handles vehicle catalog listing, filtering and sorting.
 * 
 * @author Basant Gera
 *
 */
@Controller
public class VehicleController {
  
  private static String sOrderMake = "ASC";
  private static String sOrderModel = "ASC";
  private static String sOrderYear = "ASC";
  private static String sOrderType = "ASC";
  static int vcount = 0;
  List<Vehicles> VehiclesList=null;
  RegisterController rv = new RegisterController();
  @Autowired
  private VehicleService vehicleService;
  long idDummy;
  private VehiclesDataMapper vehiclesDataMapper;

  /**
   * This method renders catalog page.
   * 
   * @param model  Vehicle Model
   * @return Retrun you list of records
   */
  @RequestMapping("/vehicle")
  public String loadVehicleListToAssign(Model model, HttpSession session) {

    String username = (String) session.getAttribute("sessionusername");
    String usergroup = (String) session.getAttribute("sessionusergroup");
    session.setAttribute("mySessionAttribute", usergroup);
    session.setAttribute("mySessionAttribute1", username);
    session.setAttribute("vehicleVersion", null);
    if (username != null) {
      vehiclesDataMapper = new VehiclesDataMapper();
       VehiclesList = vehiclesDataMapper.getVehiclesData();

      model.addAttribute("vehicle", VehiclesList);
      return "vehicle";
    } else {
      return "redirect:/loginpage";
    }

  }

  /**
   * This method redirects to get detailed view page.
   * 
   * @param VehiclesAttributes All submitted form in List
   * @param model Vehicle Model
   * @return You the list of Variables
   */
  @PostMapping("/vehicle")
  public String fncSearchAddedVehicle(@ModelAttribute(name = "${vehicleform}") Vehicles VehiclesAttributes,
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
//    if (!(iSize == 0) || !(listVehicles.equals(null))) {
//
//      listVehicles = vehicleService.ListAllSearches(sMake.trim(), sType.trim(), sModel.trim(),
//          sYear.trim(), checkboxValue.trim(), checkboxValue1.trim());
//    }
    vehiclesDataMapper = new VehiclesDataMapper();
   VehiclesList = vehiclesDataMapper.getVehiclesDataViaSearch(sMake.trim(), sType.trim(), sModel.trim(),sYear.trim(), checkboxValue.trim(), checkboxValue1.trim());
    
    model.addAttribute("vehicle", VehiclesList);
    return "vehicle";

  }

  /**
   * This method handles sorting functionality by make.
   * 
   * @param model Vehicle Model
   * @return You list in soreted order ASC/DESC
   */
  @RequestMapping(value = "/vehicle", params = "btnSortMake", method = RequestMethod.POST)
  public String sortbasedOnMake(Model model) {

    ModelWrapper listVehicles = vehicleService.listAll();
    if (sOrderMake.equals("DESC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o1.getMake().compareTo(o2.getMake()));
      sOrderMake = "ASC";
    } else if (sOrderMake.equals("ASC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o2.getMake().compareTo(o1.getMake()));
      sOrderMake = "DESC";
    }

    model.addAttribute("vehicle", VehiclesList);
    return "vehicle";

  }

  /**
   * This method handles sorting functionality by model.
   * 
   * @param model Vehicle Model
   * @return You list in soreted order ASC/DESC
   */
  @RequestMapping(value = "/vehicle", params = "btnSortModel", method = RequestMethod.POST)
  public String sortbasedOnModel(Model model) {

    ModelWrapper listVehicles = vehicleService.listAll();
    if (sOrderModel.equals("DESC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o1.getModel().compareTo(o2.getModel()));
      sOrderModel = "ASC";
    } else if (sOrderModel.equals("ASC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o2.getModel().compareTo(o1.getModel()));
      sOrderModel = "DESC";
    }

    model.addAttribute("vehicle", VehiclesList);
    return "vehicle";

  }

  /**
   * This method handles sorting functionality by year.
   * 
   * @param model Vehicle Model
   * @return You list in soreted order ASC/DESC
   */
  @RequestMapping(value = "/vehicle", params = "btnSortYear", method = RequestMethod.POST)
  public String sortbasedOnyear(Model model) {

    ModelWrapper listVehicles = vehicleService.listAll();
    if (sOrderYear.equals("DESC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o1.getiYear().compareTo(o2.getiYear()));
      sOrderYear = "ASC";
    } else if (sOrderYear.equals("ASC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o2.getiYear().compareTo(o1.getiYear()));
      sOrderYear = "DESC";
    }

    model.addAttribute("vehicle", VehiclesList);
    return "vehicle";

  }

  /**
   * This method redirects to client manager.
   * 
    * @param model Vehicle Model
   * @return Redireted you to Clients screen
   */
  @RequestMapping(value = "/vehicle", params = "btnClientManager", method = RequestMethod.POST)
  public String btnClientManager(Model model) {

    return "redirect:/clients";

  }

  /**
   * This method is used to sort Vehicles based on Type.
   * 
  * @param model Vehicle Model
   * @return You list in sorted order ASC/DESC
   */

  @RequestMapping(value = "/vehicle", params = "btnSortVechicles", method = RequestMethod.POST)
  public String sortbasedOnType(Model model) {

    ModelWrapper listVehicles = vehicleService.listAll();
    if (sOrderType.equals("DESC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o1.getiYear().compareTo(o2.getType()));
      sOrderType = "ASC";
    } else if (sOrderType.equals("ASC")) {
      Collections.sort(VehiclesList,
          (o1, o2) -> o2.getiYear().compareTo(o1.getType()));
      sOrderType = "DESC";
    }

    model.addAttribute("vehicle", VehiclesList);
    return "vehicle";

  }

  /**
   * This method is used to fetch the id of selected vehicle in vehicle page and pass it in detailed
   * view to populate its attributes
   * 
   * @param id of vehicle 
   * @param model
   * @return vehicle details
   */

  @RequestMapping("/VehilceId/{id}")
  public ModelAndView btnGetIdtoDetailedView(@PathVariable(name = "id") Long id, Model model, HttpSession session) {
    ModelAndView sDetailsmav = new ModelAndView("DetailedViewPage");
    Long vehicleid=id;
    session.setAttribute("vehicleidAttribute", vehicleid);
    Long vehicleVersion = null;
    if(session.getAttribute("vehicleVersion") == null) {
    
    vehicleVersion = (long) vehiclesDataMapper.getVehicleVersion(vehicleid);
    session.setAttribute("vehicleVersion", vehicleVersion);
    }
    
    Vehicles VechilesDetails = vehiclesDataMapper.getRecord(id);
    sDetailsmav.addObject("vehicleForDetails", VechilesDetails);
    return sDetailsmav;
  }

  /**
   * Method to return next vehicle in the vehicle catalog in detailed view page
   * 
   * @param id  
   * @param model
   * @return next vehicle
   * 
   */

  @RequestMapping("/next/{id}")
  public ModelAndView btnNextVehicleDetails(@PathVariable(name = "id") Long id, Model model,HttpSession session) {
    ModelAndView sDetailsmav = new ModelAndView("DetailedViewPage");
    Vehicles VechilesDetails = vehiclesDataMapper.getNextVehicle(id);
    Long nextId=VechilesDetails.getId().longValue();
    session.setAttribute("vehicleidAttribute", nextId);
    Long vehicleVersion = (long) vehiclesDataMapper.getVehicleVersion(nextId);
    session.setAttribute("vehicleVersion", vehicleVersion);
    sDetailsmav.addObject("vehicleForDetails", VechilesDetails);
    return sDetailsmav;
  }

 
  @RequestMapping(value = "/saveRec", params = "reserve", method = RequestMethod.POST)
  public String bookingDetails(Model model,HttpSession session,  RedirectAttributes ra) {
    String username = (String) session.getAttribute("sessionusername");
    String bookingStatus="reserve";
    
    session.setAttribute("sessionButtonAttribute11", bookingStatus);
    if (username != null) {
      model.addAttribute("bookingn", new ModelWrapper());

      model.addAttribute("bookingn", new ModelWrapper());

      return "bookingForm";
    } else
      return "redirect:/loginpage";

  }
 /**
  * 
  * @param model
  * @param session
  * @return
  */
  @RequestMapping(value = "/saveRec", params = "rent", method = RequestMethod.POST)
  public String bookingDetail(Model model,HttpSession session, RedirectAttributes ra) {
    String username = (String) session.getAttribute("sessionusername");
    String bookingStatus="rent";
    LocalDate localDate = LocalDate.now();
    String currentdate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
    session.setAttribute("sessionCurrentDate", currentdate);
    session.setAttribute("sessionButtonAttribute11", bookingStatus);
    if (username != null) {
      model.addAttribute("bookingn", new ModelWrapper());
      
      model.addAttribute("bookingn", new ModelWrapper());

      return "bookingForm";
    } else
      return "redirect:/loginpage";

  }

  /**
   * This method is used to Go Back to Vehicle Catalog from Detailed View Page on Click of Go Back
   * button
   * 
   * @param model
   * @return redirection to vehicle catalog
   */

  @RequestMapping(value = "/saveRec", params = "btnGoBack", method = RequestMethod.POST)
  public String btnGoBack(Model model) {

    return "redirect:/vehicle";

  }
  /**
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = "/vehicle", params = "logout", method = RequestMethod.POST)
  public String logout(Model model) {
    ClerksDataMapper.resetAdminLogin();
    return "redirect:/loginpage";
  }
}
