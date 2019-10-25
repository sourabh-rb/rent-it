package com.rentit.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rentit.model.BookingService;
import com.rentit.model.ModelWrapper;
import com.rentit.model.Vehicles;

/**
 * BookingHistory Controller is used to render booking manager.
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
@Controller
public class BookingHistoryController {

  @Autowired
  private BookingService bookingService;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  /**
   * 
   * This method is used to render booking manager view.
   * 
   * @param model : model to hold attributes of bookings
   * @return booking-manager : booking manager view
   */
  @RequestMapping("/transactions")
  public String listClient(Model model) {
    String username = LoginController.username;
    if (username != null) {
      List<ModelWrapper> listBookings = bookingService.listAll();
      model.addAttribute("bookings", listBookings);
      return "booking-manager";
    } else
      return "redirect:/loginpage";
  }

  /**
   * This method is used to handle filter criteria of transaction page.
   * 
   * @param transactionAttributes
   * @param model
   * @return
   */

  @RequestMapping(value = "/transactions", method = RequestMethod.POST)
  public String getDetailOftransactions(
      @ModelAttribute("transactionob") ModelWrapper transactionAttributes, Model model) {
    // List<ModelWrapper> listBookings = bookingService.listAll();

    ModelWrapper listBookings = (ModelWrapper) bookingService.listAll();

    String cname = transactionAttributes.getClient().getFirstName();
    String vehicle = transactionAttributes.getVehicle().getModel();
    String duedate = transactionAttributes.getBooking().getDueDate();
    String startdate = transactionAttributes.getBooking().getStartDate();
    if (!(listBookings.equals(null))) {

      listBookings =
          (ModelWrapper) bookingService.ListAlltransactions(cname, vehicle, duedate, startdate);
    }
    model.addAttribute("bookings", listBookings);
    return "booking-manager";

  }



}
