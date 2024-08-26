package com.apro.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Employee;
import com.apro.main.exceptions.EmployeeNotFoundException;
import com.apro.main.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Page<Employee> getEmployeesByPage(int pageNumber,int pageSize){
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			return employeeRepository.findAll(pageable);
	}
	
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> optionalEmployee= employeeRepository.findById(id);
		
		if(!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		return optionalEmployee.get();
	}
	
	public Page<Employee> getEmployeesByFirstName(String firstName,int pageNumber,int pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findByFirstName(firstName, pageable);
	}
	
	
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
