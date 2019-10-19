package com.rentit.controller;


import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.rentit.model.Vehicles;
import com.rentit.model.ModelWrapper;
import com.rentit.model.VehicleService;

/**
 * This class renders details view.
 * 
 * @author Arvind
 *
 */
@Controller
public class DetailedViewController {

  @Autowired
  private VehicleService vehicleService;

  /**
   * This method renders details view page.
   * 
   * @return
   */
  @RequestMapping(value = "/DetailedViewPage", method = RequestMethod.GET)

  public String getDetailedViewPage() {
    String username = LoginController.username;
    if (username != null)
      return "DetailedViewPage";

    else
      return "redirect:/loginpage";

  }



}
