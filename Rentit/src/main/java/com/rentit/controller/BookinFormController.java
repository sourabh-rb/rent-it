package com.rentit.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.rentit.data_source.BookingsDataGateway;
import com.rentit.data_source.ClerksDataGateway;
import com.rentit.model.Bookings;
import com.rentit.model.BookingsDataMapper;
import com.rentit.model.ClerksDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * This class handles booking functionalities.
 * 
 * @author Sourabh Rajeev Badagandi , Anusha Keralapura Thandavamurthy
 *
 */
@Controller
public class BookinFormController {
  
  private BookingsDataGateway  bookingsDataGateway;

  static LocalDate localDate = LocalDate.now();
  String currentdate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
  Date currentdate1 = null;
  Date startdate1 = null;
  Date duedate1 = null;
  Date licenseexpiry1 = null;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  @Autowired
  private ClientsService clientService;

  private VehicleService vehicleService;

  /**
   * This method renders booking page.
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = "/bookingForm")
  public String bookingDetails(Model model,HttpSession session) {
    String username = (String) session.getAttribute("sessionusername");
    
    
    
    if (username != null) {
      model.addAttribute("bookingn", new ModelWrapper());
      
      return "bookingForm";
    } else
      return "redirect:/loginpage";

  }

  /**
   * This method confirms booking upon validation.
   * 
   * @param newBooking
   * @param model
   * @param startDate
   * @param dueDate
   * @param licenceValidity
   * @return
   */
  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  public String bookVehicle(@ModelAttribute("bookingn") ModelWrapper newBooking, Model model,HttpSession session) {

    BookingsDataGateway bg = new BookingsDataGateway();
    BookingsDataMapper bdm = new BookingsDataMapper();
    ClientsDataMapper cdm = new ClientsDataMapper();
    
    boolean valid = false;
    try {
      currentdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);
      
      String bookingStatus=(String)session.getAttribute("sessionButtonAttribute11");
      if(bookingStatus=="rent") {
        startdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);
      }
      else {
        startdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(newBooking.getBooking().getStartDate());
      }
      duedate1 = new SimpleDateFormat("yyyy-MM-dd").parse(newBooking.getBooking().getDueDate());
      licenseexpiry1 =
          new SimpleDateFormat("yyyy-MM-dd").parse(newBooking.getClient().getLicenceValidity());

    } catch (ParseException e) {
      e.printStackTrace();
    }

    if (startdate1.after(currentdate1) || startdate1.equals(currentdate1)
        && duedate1.after(startdate1) && licenseexpiry1.after(duedate1)) {
      valid = true;
    }

    if (startdate1.before(currentdate1)) {
      valid = false;
    }
    if (duedate1.before(startdate1)) {
      valid = false;

    }
    if (licenseexpiry1.before(duedate1)) {
      valid = false;


    }

    if (valid == false) {
      model.addAttribute("startDate", true);
      return "bookingForm";
    } else {
      // newBooking.setVehicle(vehicleService.getBookVehicle());
      
     // bdm.addBookingRecord(newBooking);
      //cdm.addClientRecord(newBooking);
     clientService.saveNewBooking(newBooking);
      return "redirect:/clients";
    }


  }

}
