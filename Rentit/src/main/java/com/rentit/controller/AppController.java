package com.rentit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class handles rendering of landing page.
 * @author Sourabh Rajeev Badagandi
 *
 */
@Controller
@RequestMapping("/")
public class AppController {
	
	/**
	 * This method renders the landing page.
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
	    return "index";
	}
	


}
