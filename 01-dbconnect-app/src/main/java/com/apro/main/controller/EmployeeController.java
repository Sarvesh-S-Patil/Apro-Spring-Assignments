package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Employee;
import com.apro.main.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee-app")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Record added successfully";
	}
	
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId){
		return ResponseEntity.ok(employeeService.findEmployeeById(employeeId));
	}
	
	@GetMapping("/employees/name")
	public ResponseEntity<List<Employee>> getStudentByName (@RequestParam String name) {
		return ResponseEntity.ok(employeeService.getEmployeesByName(name));
	}
	
}
