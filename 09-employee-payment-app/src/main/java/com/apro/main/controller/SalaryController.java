package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Salary;
import com.apro.main.service.SalaryService;

@RestController
@RequestMapping("/employee-app")
public class SalaryController {
	@Autowired
	SalaryService salaryService;
	
	@PostMapping("/salary")
	public Salary addSalary(@RequestBody Salary salary) {
		return salaryService.addSalary(salary);
	}
	
	@GetMapping("/salary")
	public List<Salary> getSalaries(){
		return salaryService.findAllSalary();
	}
	
	@DeleteMapping("/salary")
	public String deleteSalaryById(@RequestParam long salaryId) {
		salaryService.deleteSalaryById(salaryId);
		return "Salary deleted successfully";
	}
	
	@GetMapping("/salary/{id}")
	public Salary getSalaryById(@PathVariable long id) {
		return salaryService.getSalaryById(id);
	}
	

}
