package com.apro.main.repo;

import java.util.List;

import com.apro.main.entity.Employee;

public interface EmployeeRepo {
	
	public List<Employee> getAllEmployee();
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployeeById(int employeeId);
	
	public List<Employee> getEmployeeByName(String name);

}
