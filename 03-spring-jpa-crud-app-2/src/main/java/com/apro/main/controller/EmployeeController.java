package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Employee;
import com.apro.main.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee-app")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Page<Employee> getEmployees(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam (required = false) String firstName){
		if(firstName != null) {
			return employeeService.getEmployeesByFirstName(firstName, pageNumber, pageSize);
		}
		return employeeService.getEmployeesByPage(pageNumber, pageSize);
	}
	
	@PostMapping("/employees")
	public String addEmployee(@Valid @RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee added successfully";
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "Employee deleted successfully";
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
}
