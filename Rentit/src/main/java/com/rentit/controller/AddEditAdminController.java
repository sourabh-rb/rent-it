package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddEditAdminController {



  @RequestMapping("/addEditAdmin")
  public String AddEditVehicle(Model model) {
    String username = LoginController.username;
    if (username != null)
      return "addEditAdmin";
    else
      return "redirect:/loginpage";

  }


}
