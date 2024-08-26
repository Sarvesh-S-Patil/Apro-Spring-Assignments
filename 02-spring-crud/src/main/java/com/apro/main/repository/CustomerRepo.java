package com.apro.main.repository;

import java.util.List;

import com.apro.main.entity.Customer;



public interface CustomerRepo{
	
	public List<Customer> getAllCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId);
	
	public List<Customer> getCustomerByFirstName(String name);
	
	
	public void deleteCustomer(int customerId);

}
