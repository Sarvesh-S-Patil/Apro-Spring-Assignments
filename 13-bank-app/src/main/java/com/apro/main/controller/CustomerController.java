package com.apro.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.CustomerDTO;
import com.apro.main.service.CustomerService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/bank-app")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public CustomerDTO getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/customers")
	@PreAuthorize("hasRole('ADMIN')")
	public List<CustomerDTO> getCustomers(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping("/customers")
	@PreAuthorize("hasRole('ADMIN')")
	public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		return customerService.addCustomer(customerDTO);
	}
	
	@DeleteMapping("/customers")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteCustomer(@RequestParam Long id) {
		customerService.removeCustomer(id);
		return "Customer Deleted Successfully";
	}
	
	
	
	
	
}
