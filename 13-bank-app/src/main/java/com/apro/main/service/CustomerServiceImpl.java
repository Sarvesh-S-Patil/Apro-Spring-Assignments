package com.apro.main.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.CustomerDTO;

import com.apro.main.entity.Customer;
import com.apro.main.entity.User;
import com.apro.main.exception.CustomerNotFoundException;
import com.apro.main.exception.UserApiException;
import com.apro.main.exception.UserNotFoundException;
import com.apro.main.repository.CustomerRepository;
import com.apro.main.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public CustomerDTO addCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		boolean user_exists = userRepository.existsByUserName(username);
		if(user_exists==false)
			throw new UserApiException();
		Customer customer = CustomerDTO.toCustomerMapper(customerDTO);
		int userId = customerDTO.getUserId();
		User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
		customer.setUser(user);
		Customer customerDb = customerRepo.save(customer);
		return CustomerDTO.toCustomerDtoMapper(customerDb);
	}

	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new CustomerNotFoundException());
		return CustomerDTO.toCustomerDtoMapper(customer);
	}

	@Override
	public void removeCustomer(Long customerId) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new CustomerNotFoundException());
		customerRepo.delete(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepo.findAll();
		List<CustomerDTO> customersDTO = new ArrayList<>();
		customers.forEach((customer) ->  
		{
			customersDTO.add(CustomerDTO.toCustomerDtoMapper(customer));
		}
		);
		return customersDTO;
	}

}
