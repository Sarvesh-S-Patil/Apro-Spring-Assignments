package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Client;
import com.apro.main.entity.Employee;
import com.apro.main.service.ClientService;

@RestController
@RequestMapping("/employee-app")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/client")
	public Client getClientById(long clientId) {
		return clientService.getClient(clientId);
	}
	@PostMapping("/client")
	public Client addClient(Client client) {
		return clientService.addClient(client);
	}
	@PostMapping("/client/employee/add")
	public Client updateClientEmployee(long clientId,Employee employee) {
		return clientService.addEmployeToClient(clientId, employee);
	}
}
