package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apro.main.entity.SalaryTransaction;
import com.apro.main.service.SalaryAccountService;
import com.apro.main.service.SalaryTransactionService;


@Controller
@RequestMapping("/employee-app")
public class SalaryTransactionController {
	
	@Autowired
	SalaryTransactionService salaryTransactionService;
	
	@PostMapping("/salary-transaction")
	public SalaryTransaction addTransaction(@RequestBody SalaryTransaction salaryTransaction) {
		return salaryTransactionService.addTransaction(salaryTransaction);
	}
	
	@GetMapping("/salary-transaction")
	public SalaryTransaction getTransaction(@RequestParam long transactionId) {
		return salaryTransactionService.getTransaction(transactionId);
	}
	
	
}
