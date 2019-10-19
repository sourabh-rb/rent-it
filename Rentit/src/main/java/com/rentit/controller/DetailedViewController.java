package com.rentit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class renders Detailed View for vehicles.
 * 
 * @author Arvind Adiga
 *
 */
@Controller
public class DetailedViewController {


  /**
   * This method renders detailed view page if user is valid,else redirects to login page.
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
