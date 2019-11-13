package com.rentit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import com.rentit.model.BookingFilter;
import com.rentit.model.BookingService;
import com.rentit.model.Bookings;
import com.rentit.model.BookingsDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ModelWrapper;
import com.rentit.model.Vehicles;
import com.rentit.model.VehiclesDataMapper;

/**
 * BookingHistory Controller is used to render booking manager.
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
@Controller
public class BookingHistoryController {

  private BookingService bookingService;
  private ClientsDataMapper clientDataMapper;
  private BookingsDataMapper bookingDataMapper;
  private VehiclesDataMapper vehicleDataMapper;

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
  public String listTransactions(Model model, HttpSession session) {
    String username = (String) session.getAttribute("sessionusername");
    if (username == null) {
      bookingDataMapper = new BookingsDataMapper();

      BookingFilter filterCriteria = new BookingFilter();
      ArrayList<ArrayList<String>> t = bookingDataMapper.getTransactionDetails(filterCriteria.getClientFirstName(), filterCriteria.getClientLastName(),
          filterCriteria.getVehicleModel(), filterCriteria.getVehicleMake(), filterCriteria.getStartDate(), filterCriteria.getDueDate());
      model.addAttribute("bookings", t);
      return "booking-manager";
    } else
      return "redirect:/loginpage";
  }

  private ArrayList<String> getBookingIdList(List<Clients> clients) {
    ArrayList<String> idList = new ArrayList<String>();
    for(Clients cli : clients) {
      idList.add(cli.getBookingId().toString());
    }
    return idList;
  }
  
  private ArrayList<String> getVehicleIdList(List<Clients> clients) {
    ArrayList<String> idList = new ArrayList<String>();
    for(Clients cli : clients) {
      idList.add(cli.getVehicleId().toString());
    }
    return idList;
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
      @ModelAttribute("transactionob") BookingFilter filterOptions, Model model) {

    BookingFilter filterCriteria = new BookingFilter();
    filterCriteria = filterOptions;
    
    ArrayList<ArrayList<String>> t = bookingDataMapper.getTransactionDetails(filterCriteria.getClientFirstName(), filterCriteria.getClientLastName(),
        filterCriteria.getVehicleModel(), filterCriteria.getVehicleMake(), filterCriteria.getStartDate(), filterCriteria.getDueDate());
    model.addAttribute("bookings", t);
    
    return "booking-manager";

  }



}
