package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
