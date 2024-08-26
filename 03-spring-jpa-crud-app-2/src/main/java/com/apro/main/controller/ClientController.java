package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Client;
import com.apro.main.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client-app")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/clients")
	public Page<Client> getClientsByPage(@RequestParam  int pageNumber,@RequestParam int pageSize,@RequestParam (required = false) String companyName) {
		if(companyName !=null) {
			return clientService.getClientsByCompanyName(pageNumber, pageSize, companyName);
		}
		return clientService.getClients(pageNumber, pageSize);
	}
	
	@PostMapping("/clients")
	public String addClient(@Valid @RequestBody Client client) {
		clientService.addClient(client);
		return "Client Added Successfully";
	}
	
	
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable int id) {
		return clientService.findClientById(id);
	}
	
	
	@DeleteMapping("/clients")
	public String deleteClientById(@RequestParam int clientId) {
		clientService.deleteClientById(clientId);
		return "Client Deleted Successfully";
	}
	

}
