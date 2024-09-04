package com.apro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Customer;
import com.apro.main.repository.CustomerRepository;


@Service
public class CustomerServiceImpl  implements CustomerService{
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepo.findById(customerId).orElseThrow(() -> new NullPointerException());
	}

}
