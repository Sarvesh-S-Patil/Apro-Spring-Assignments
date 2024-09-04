package com.apro.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Customer;
import com.apro.main.entity.User;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
	Customer findByUser(User user);
}
