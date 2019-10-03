package com.rentit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Clients;
import com.rentit.model.ClientsService;
import com.rentit.test_class.TestClass;

@Controller
public class DetailedViewController {
	
	@RequestMapping(value="/DetailedViewPage",method=RequestMethod.GET)
	  public String getDetailedViewPage() {
	   return "DetailedViewPage"; 
	  }

	

}
