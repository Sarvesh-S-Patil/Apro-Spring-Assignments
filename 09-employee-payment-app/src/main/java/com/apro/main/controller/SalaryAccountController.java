package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Bank;
import com.apro.main.entity.SalaryAccount;
import com.apro.main.service.SalaryAccountService;

@RestController
@RequestMapping("/employee-app")
public class SalaryAccountController {
	@Autowired
	SalaryAccountService salaryAccountService;
	
	@GetMapping("/account")
	public SalaryAccount getAccount(@RequestParam long accountNumber) {
		return salaryAccountService.getSalaryAccount(accountNumber);
	}
	
	@PostMapping("/account")
	public SalaryAccount addAccount(@RequestBody SalaryAccount account) {
		return salaryAccountService.addSalaryAccount(account);
	}
	
	@PostMapping("/account/bank/set")
	public SalaryAccount setBank(@RequestParam long accountNumber,@RequestBody Bank bank) {
		return salaryAccountService.setBank(accountNumber, bank);
	}

}
