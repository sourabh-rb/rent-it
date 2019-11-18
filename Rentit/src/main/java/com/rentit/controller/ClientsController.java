package com.rentit.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rentit.model.Bookings;
import com.rentit.model.BookingsDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ClientsService;
import com.rentit.model.VehiclesDataMapper;



/**
 * Clients Controller
 * 
 * Clients controller is responsible loading the clients manager view and handling return,
 * cancellation and modification of client details.
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
@Controller
public class ClientsController {

  @Autowired
  private ClientsService clientService;
  private ClientsDataMapper clientDataMapper;
  private BookingsDataMapper bookingDataMapper;
  private VehiclesDataMapper vehicleDataMapper;

  /**
   * 
   * This method is used to render client manager view.
   * 
   * @param model : model to hold attributes of clients
   * @return client-manager : client manager view
   */
  @RequestMapping("/clients")
  public String listClient(Model model,HttpSession session) {
    String username = (String) session.getAttribute("sessionusername");
    if (username != null) {
      clientDataMapper = new ClientsDataMapper();
      bookingDataMapper = new BookingsDataMapper();
      vehicleDataMapper = new VehiclesDataMapper();
      
      List<Clients> c = clientDataMapper.getClientData();
      List<Bookings> b = bookingDataMapper.getBookingData();
      
      model.addAttribute("clients", c);
      model.addAttribute("booking", b);
      return "client-manager";
    } else
      return "redirect:/loginpage";
  }

  /**
   * This method handles return of vehicle by customer.
   * 
   * @param id Client id
   * @return redirection to clients page
   */
  @RequestMapping("/return/{id}")
  public String returnVehicle(@PathVariable(name = "id") Long id) {
    Long bookingVersion = bookingDataMapper.getBookingVersion(id);
    bookingDataMapper.processReturn(id, bookingVersion);
    
    Long vehicleId = bookingDataMapper.getVehicleId(id);
    Long vehicleVersion = (long) vehicleDataMapper.getVehicleVersion(vehicleId);
    vehicleDataMapper.removeBooking(vehicleId, vehicleVersion);
    
    Long clientId = bookingDataMapper.getClientId(id);
    Long clientVersion = clientDataMapper.getClientVersion(clientId);

    int res = clientDataMapper.removeBookingandVehicle(clientId, clientVersion);
    if(res > 0) {
    bookingDataMapper.updateVersion(id, bookingVersion);
    clientDataMapper.updateVersion(clientId, clientVersion);
    vehicleDataMapper.updateVersion(vehicleId, vehicleVersion);
    }
    
    return "redirect:/clients";
  }

  /**
   * This method handles cancellation of booking by customer.
   * 
   * @param id Client id
   * @return redirection to clients page
   */
  @RequestMapping("/cancel/{id}")
  public String cancelBooking(@PathVariable(name = "id") Long id) {
    Long bookingVersion = bookingDataMapper.getBookingVersion(id);
    bookingDataMapper.processCancel(id, bookingVersion);
    
    Long vehicleId = bookingDataMapper.getVehicleId(id);
    Long vehicleVersion = (long) vehicleDataMapper.getVehicleVersion(vehicleId);
    vehicleDataMapper.removeBooking(vehicleId, vehicleVersion);
    
    Long clientId = bookingDataMapper.getClientId(id);
    Long clientVersion = clientDataMapper.getClientVersion(clientId);
    
    int res = clientDataMapper.removeBookingandVehicle(clientId, clientVersion);
    
    if(res > 0) {
    bookingDataMapper.updateVersion(id, bookingVersion);
    clientDataMapper.updateVersion(clientId, clientVersion);
    vehicleDataMapper.updateVersion(vehicleId, vehicleVersion);
    }
    return "redirect:/clients";
   
  }
  
  /**
   * This method handles deletion of booking by clerk.
   * 
   * @param client id
   * @return redirection to clients page
   */
  @RequestMapping("/deleteRecord/{id}")
  public String deleteBooking(@PathVariable(name = "id") Long id) {
    Long vehicleId = bookingDataMapper.getVehicleId(id);
    Long vehicleVersion = (long) vehicleDataMapper.getVehicleVersion(vehicleId);
    vehicleDataMapper.removeBooking(vehicleId, vehicleVersion);
    
    Long bookingVersion = bookingDataMapper.getBookingVersion(id);
    bookingDataMapper.processDelete(id, bookingVersion);
    
    return "redirect:/clients";
  }

  /**
   * This method handles return of modify customer details.
   * 
   * @param id Client id
   * @return redirection to modify client page.
   */
  @RequestMapping("/modify/{id}")
  public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
    ModelAndView mav = new ModelAndView("client-modify");
    Clients clientDetails = clientDataMapper.getRecord(id);
    mav.addObject("modify", clientDetails);

    return mav;
  }

  /**
   * This method handles saving details.
   * 
   * @param clientDetails
   * @return redirect to clients.
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveEdit(@ModelAttribute("modify") Clients clientDetails,RedirectAttributes ra) {
   int upd = clientDataMapper.modifyRecord(clientDetails);
  if(upd>0)
    return "redirect:/clients";
  else {
    ra.addFlashAttribute("modify", true);
    return  "redirect:/clients";
  }
  }

  /**
   * This method handles cancellation of edit details.
   * 
   * @param clientDetails
   * @return redirection to clients.
   */
  @RequestMapping(value = "/cancel", method = RequestMethod.POST)
  public String cancelEdit(@ModelAttribute("modify") Clients clientDetails) {

    return "redirect:/clients";
  }



}
