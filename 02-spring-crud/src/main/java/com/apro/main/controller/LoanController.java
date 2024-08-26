package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Customer;
import com.apro.main.entity.Loan;
import com.apro.main.service.CustomerService;
import com.apro.main.service.LoanService;

@RestController
@RequestMapping("/loan-app")
public class LoanController {
	@Autowired
	LoanService loanService;
	
	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> getAllLoans(){
		return ResponseEntity.ok(loanService.getAllLoans());
	}
	
	@PostMapping("/loans")
	public String addLoan(@RequestBody Loan loan) {
		loanService.addLoan(loan);
		return "Loan added successfully";
	}
	
	
	@GetMapping("/loans/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
		 return ResponseEntity.ok(loanService.getLoanById(id));
	}
	
	@GetMapping("/loan/loanstatus")
	public ResponseEntity<List<Loan>>  getLoanByStatus(@RequestParam String status){
		return ResponseEntity.ok(loanService.getLoanByStatus(status));
	}
	
	@DeleteMapping("/delete/{loanId}")
	public String deleteLoan(@PathVariable int loanId) {
		loanService.deleteLoan(loanId);
		return "Loan Deleted Successfully";
	}
}
