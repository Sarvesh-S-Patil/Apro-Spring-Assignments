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
import com.apro.main.service.BankService;

@RestController
@RequestMapping("/employee-app")
public class BankController {
	@Autowired
	BankService bankService;
	
	@GetMapping("/bank")
	public Bank getBankById(@RequestParam long bankId) {
		return bankService.getBankById(bankId);
	}
	
	@PostMapping("/bank")
	public Bank addBank(@RequestBody Bank bank) {
		return bankService.addBank(bank);
	}
	
	@PostMapping("/bank/account/add")
	public Bank addNewBankAccount(@RequestParam long bankId ,@RequestBody SalaryAccount account) {
		return bankService.addNewBankAccount(bankId, account);
	}
}
