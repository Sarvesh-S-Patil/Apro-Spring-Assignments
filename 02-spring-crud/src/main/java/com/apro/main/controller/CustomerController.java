package com.apro.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Customer;
import com.apro.main.service.CustomerService;

@RestController
@RequestMapping("/customer-app")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return "Customer added successfully";
	}
	
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		 return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@GetMapping("/customers/firstName")
	public ResponseEntity<List<Customer>>  getCustomerByFirstName(@RequestParam String name){
		return ResponseEntity.ok(customerService.getCustomerByFirstName(name));
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return "Customer Deleted Successfully";
	}
	
}
