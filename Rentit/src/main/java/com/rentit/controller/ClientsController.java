package com.rentit.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.rentit.model.Bookings;
import com.rentit.model.BookingsDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;
import com.rentit.test_class.TestClass;



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

  /**
   * 
   * This method is used to render client manager view.
   * 
   * @param model : model to hold attributes of clients
   * @return client-manager : client manager view
   */
  @RequestMapping("/clients")
  public String listClient(Model model) {
    String username = LoginController.username;
    if (username == null) {
      TestClass tc = new TestClass();
      clientDataMapper = new ClientsDataMapper();
      bookingDataMapper = new BookingsDataMapper();
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
    bookingDataMapper.processReturn(id);
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
    bookingDataMapper.processCancel(id);
    return "redirect:/clients";
  }
  
  /**
   * This method handles deletion of booking by clerk.
   * 
   * @param id Client id
   * @return redirection to clients page
   */
  @RequestMapping("/deleteRecord/{id}")
  public String deleteBooking(@PathVariable(name = "id") Long id) {
    bookingDataMapper.processDelete(id);
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
    //Clients clientDetails = clientService.getClientInfo(id);
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
  public String saveEdit(@ModelAttribute("modify") Clients clientDetails) {

    //clientService.saveClientInfo(clientDetails);
    clientDataMapper.modifyRecord(clientDetails);

    return "redirect:/clients";
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
