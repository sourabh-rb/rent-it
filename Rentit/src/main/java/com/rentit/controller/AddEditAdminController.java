package com.rentit.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for AddEditAdmin page
 * 
 * @author Basant Gera
 *
 */

@Controller
public class AddEditAdminController {

  /**
   * Redirects to login page if not a valid user, else display addEditAdmin page
   * 
   * @param model
   * @return redirect to login page
   */

  @RequestMapping("/addEditAdmin")
  public String AddEditVehicle(Model model, HttpSession session) {
    String username = (String) session.getAttribute("sessionusername");
    String usergroup = (String) session.getAttribute("sessionusergroup");
    if (username != null && usergroup == "admin")
      return "addEditAdmin";
    else if (username != null && usergroup == "clerk")
      return "redirect:/vehicle";
    else
      return "redirect:/loginpage";

  }

}
