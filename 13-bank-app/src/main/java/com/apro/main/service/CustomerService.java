package com.apro.main.service;

import java.util.List;

import com.apro.main.DTO.CustomerDTO;

public interface CustomerService {
	public CustomerDTO addCustomer(CustomerDTO customerDTO);
	public CustomerDTO getCustomerById(Long customerId);
	public void removeCustomer(Long customerId);
	
	public List<CustomerDTO> getAllCustomers();
}
