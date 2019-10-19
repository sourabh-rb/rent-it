package com.rentit.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.rentit.model.Clerks;
import com.rentit.model.ClerksService;
import com.rentit.test_class.TestClass;


/**
 * This class control the viewpage and model of registration
 * 
 * @author charan
 *
 */
@Controller
public class RegisterController {
  static String usergrp;

  /**
   * This method is to pass the data to registration page
   * 
   * @return model data
   */
  @RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
  public ModelAndView getUserDetails() {
    ModelAndView model = new ModelAndView("registrationpage");
    Clerks obj = new Clerks();
    model.addObject("Clerks", obj);
    return model;

  }

  /**
   * This methos is to get details from the view
   * 
   * @param register is a object which stores the view data
   * @param model is model data
   * @return view page or view name to redirect
   */
  @RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
  public String getDetail(@ModelAttribute("clerks") Clerks clerks, Model model) {

    String usergroup = clerks.getusergroup();
    if (usergroup != null) {
      usergrp = "admin";
    } else {
      usergrp = "clerk";
    }
    if (clerks.getFirstName() != null && clerks.getLastName() != null
        && clerks.getUsername() != null && clerks.getPassword() != null
        && clerks.getEmail() != null) {
      TestClass tc = new TestClass();
      ArrayList<Clerks> clerkslist = new ArrayList<Clerks>();
      clerkslist = (ArrayList<Clerks>) tc.getClerksTestData();

      for (int i = 0; i < clerkslist.size(); i++) {
        Clerks clerk = clerkslist.get(i);
        if (clerk.getUsername().equals(clerks.getUsername())) {
          model.addAttribute("userexits", true);
          return "registrationpage";
        }
      }
      ClerksService clerkservice = new ClerksService();
      clerkservice.addClerks(clerks);
      return "redirect:/loginpage";
    } else {
      model.addAttribute("filldetails", true);
      return "registrationpage";
    }


  }

}
