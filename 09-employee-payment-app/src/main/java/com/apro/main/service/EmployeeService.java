package com.apro.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Employee;
import com.apro.main.repository.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public Employee addEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if(!optionalEmployee.isPresent())
			return null;
		return optionalEmployee.get();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}

}
