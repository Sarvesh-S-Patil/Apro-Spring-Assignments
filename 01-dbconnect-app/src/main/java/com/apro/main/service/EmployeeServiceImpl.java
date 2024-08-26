package com.apro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Employee;
import com.apro.main.repo.EmployeeRepo;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllEmployee();
	}

	@Override

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepo.addEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub	
		return employeeRepo.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeByName(name);
	}
	
	

}
