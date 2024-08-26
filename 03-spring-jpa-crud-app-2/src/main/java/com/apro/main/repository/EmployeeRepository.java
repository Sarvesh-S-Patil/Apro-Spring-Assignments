package com.apro.main.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {
	
	Page<Employee> findByFirstName(String firstName,Pageable pageable);
}
