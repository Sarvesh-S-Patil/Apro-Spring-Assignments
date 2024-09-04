package com.apro.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
}
