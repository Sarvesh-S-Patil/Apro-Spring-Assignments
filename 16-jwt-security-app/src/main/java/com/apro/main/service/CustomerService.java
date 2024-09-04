package com.apro.main.service;

import java.util.List;

import com.apro.main.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int customerId);
}
