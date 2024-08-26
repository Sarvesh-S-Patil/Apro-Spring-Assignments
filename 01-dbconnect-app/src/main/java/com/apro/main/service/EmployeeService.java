package com.apro.main.service;

import java.util.List;

import com.apro.main.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee employee);
	
	public Employee findEmployeeById(int id);
	
	public List<Employee> getEmployeesByName(String name);

}
