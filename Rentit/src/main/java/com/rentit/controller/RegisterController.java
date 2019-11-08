package com.rentit.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.rentit.data_source.ClerksDataGateway;
import com.rentit.model.Clerks;
import com.rentit.model.ClerksDataMapper;
import com.rentit.test_class.EncryptPassword;



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
   * @throws Exception
   */
  @RequestMapping(value = "/registrationpage", method = RequestMethod.POST)
  public String getDetail(@ModelAttribute("clerks") Clerks clerks, Model model) throws Exception {
    ClerksDataGateway cg = new ClerksDataGateway();
    ClerksDataMapper cdm = new ClerksDataMapper();
    EncryptPassword ep = new EncryptPassword();
    String usergroup = clerks.getusergroup();
    if (usergroup != null) {
      usergrp = "admin";
      clerks.setusergroup("admin");
    } else {
      usergrp = "clerk";
      clerks.setusergroup("clerk");
    }
    ArrayList<String> clerkdata = new ArrayList<String>();
    String username = clerks.getUsername();
    clerkdata = cg.getEntry(username);
    if (clerkdata.isEmpty()) {
      clerks.setPassword(ep.encrypt(clerks.getPassword()));
      cdm.addClerkRecord(clerks);
      return "redirect:/loginpage";
    } else {
      model.addAttribute("userexits", true);
      return "registrationpage";
    }


  }

}
