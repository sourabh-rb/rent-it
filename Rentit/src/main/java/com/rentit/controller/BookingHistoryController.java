package com.rentit.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
   * @param transactionAttributes
   * @param model
   * @return
   */
  @PostMapping("/transactions")
  public String getDetailOftransactions(@ModelAttribute ModelWrapper transactionAttributes,
      Model model) {
    List<ModelWrapper> listBookings = bookingService.listAll();

    String cname = transactionAttributes.getClient().getFirstName();
    String vehicle = transactionAttributes.getVehicle().getModel();
    String duedate = transactionAttributes.getBooking().getDueDate();
    String startdate = transactionAttributes.getBooking().getStartDate();
    if (!(listBookings.equals(null))) {

      listBookings = bookingService.ListAlltransactions(cname.trim(), vehicle.trim(),
          duedate.trim(), startdate.trim());
    }
    model.addAttribute("booking", listBookings);
    return "transactions";

  }



}
