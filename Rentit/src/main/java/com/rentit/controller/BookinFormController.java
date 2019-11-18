package com.rentit.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rentit.data_source.BookingsDataGateway;
import com.rentit.data_source.ClerksDataGateway;
import com.rentit.data_source.ClientsDataGateway;
import com.rentit.model.Bookings;
import com.rentit.model.BookingsDataMapper;
import com.rentit.model.Clerks;
import com.rentit.model.ClerksDataMapper;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;
import com.rentit.model.ClientsService;
import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;
import com.rentit.model.VehiclesDataMapper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

  private BookingsDataGateway bookingsDataGateway;
  Date date = new Date();

  long time = date.getTime();
  static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  static LocalDate localDate = LocalDate.now();
  Timestamp ts = new Timestamp(time);
  // static long time = System.currentTimeMillis();
  String localtime = sdf.format(ts);
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

  public Long getClerkID(HttpSession session) {
    ArrayList<Clerks> clerks = new ArrayList<>();
    ClerksDataMapper cdm = new ClerksDataMapper();
    Long clerkid = null;
    clerks = cdm.getClerkData();
    for (int i = 0; i < clerks.size(); i++) {
      if (session.getAttribute("sessionusername").equals(clerks.get(i).getUsername())) {
        clerkid = clerks.get(i).getId();
        break;
      }
    }
    return clerkid;

  }

  /**
   * This method renders booking page.
   * 
   * @param model
   * @return
   */
  @RequestMapping(value = "/bookingForm")
  public String bookingDetails(Model model, HttpSession session) {
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
  public String bookVehicle(@RequestParam("firstname") String firstname,
      @RequestParam("lastname") String lastname, @RequestParam("licenseNumber") String LicenseNo,
      @RequestParam("PhoneNo") String PhoneNo, @RequestParam("startDate") String startDate,
      @RequestParam("dueDate") String dueDate,
      @RequestParam("licenceValidity") String licenceValidity, Model model, HttpSession session,RedirectAttributes ra) {

    boolean valid = false;
    try {
      currentdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);

      String bookingStatus = (String) session.getAttribute("sessionButtonAttribute11");
      if (bookingStatus == "rent") {
        startdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentdate);
      } else {
        startdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
      }
      duedate1 = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
      licenseexpiry1 = new SimpleDateFormat("yyyy-MM-dd").parse(licenceValidity);

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
      ClientsDataMapper clientsDataMap = new ClientsDataMapper();
      BookingsDataMapper bookingsDataMap = new BookingsDataMapper();
      
      
      Long vehicleId = (Long) session.getAttribute("vehicleidAttribute");
      VehiclesDataMapper vehicleDataMapper = new VehiclesDataMapper();
//      Long vehicleVersion = (long) vehicleDataMapper.getVehicleVersion(vehicleId);
//      int res = bookingsDataMap.updateVehicleBooked(vehicleId, vehicleVersion);
      
      
      Clients newClient = new Clients();
      Bookings book = new Bookings();
      newClient.setFirstName(firstname);
      newClient.setLastName(lastname);
      newClient.setLicenceNumber(LicenseNo);
      newClient.setPhone(PhoneNo);
      newClient.setLicenceValidity(licenceValidity);
      newClient.setVehicleId(vehicleId);
      newClient.setClerkid(getClerkID(session));
      newClient.setBookingId(0L);
      book.setStartDate(startDate);
      book.setDueDate(dueDate);
      book.setVehicleID(vehicleId);
      book.setBookingTS(localtime);
      book.setCancelDate(null);
      book.setReturnDate(null);
      
      Long vehicleVersion = (Long) session.getAttribute("vehicleVersion");
      int res = vehicleDataMapper.updateVehicleBooked(vehicleId, vehicleVersion);
      if(res > 0) {
      clientsDataMap.addClientRecord(newClient);
      String id1 = ClientsDataGateway.val;
      Long id = Long.parseLong(id1);
      book.setClientID(id);
      Long clientVersion = clientsDataMap.getClientVersion(id);
      
      Long vehicleVersion1 = (long) vehicleDataMapper.getVehicleVersion(vehicleId);
      bookingsDataMap.addBookingRecord(book, clientVersion, vehicleVersion1);
      return "redirect:/clients";
      }else {
        ra.addFlashAttribute("vehicleprocess", true);
        return "redirect:/vehicle";
      }
      


  }
  }

}
