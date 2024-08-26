package com.apro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Customer;
import com.apro.main.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	public List<Customer> getAllCustomers(){
		return customerRepo.getAllCustomers();
	}
	
	public void addCustomer(Customer customer) {
		customerRepo.addCustomer(customer);
	}
	
	public Customer getCustomerById(int customerId) {
		return customerRepo.getCustomerById(customerId);
	}
	
	public List<Customer> getCustomerByFirstName(String name){
		return customerRepo.getCustomerByFirstName(name);
	}
	
	
	public void deleteCustomer(int customerId) {
        customerRepo.deleteCustomer(customerId);
    }

}
