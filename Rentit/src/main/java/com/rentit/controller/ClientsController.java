package com.rentit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.rentit.model.Clients;
import com.rentit.model.ClientsService;

@Controller
public class ClientsController {
	
	@Autowired
	private ClientsService clientService;
	
	@RequestMapping("/clientManager")
	public String viewClientsPage(Model model) {
		
		List<Clients> clientList = clientService.listAll();
		model.addAttribute("clientList", clientList);
		
		return "clientManager";
	}

}
