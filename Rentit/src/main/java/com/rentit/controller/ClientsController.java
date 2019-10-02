package com.rentit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentit.model.Clients;
import com.rentit.model.ClientsService;
import com.rentit.test_class.TestClass;

@Controller
@RequestMapping("/")
public class ClientsController {
	
	@Autowired
	private ClientsService clientService;
	
	@RequestMapping("/clients")
	public String listClient(Model model) {
		
		List<Clients> listClient = clientService.listAll();
		
		model.addAttribute("clients", listClient);
		return "client-manager";
	}
	
	


}
