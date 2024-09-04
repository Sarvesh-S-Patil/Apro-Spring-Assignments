package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.TransactionDTO;
import com.apro.main.service.TransactionService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/bank-app")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction")
	@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
	public ResponseEntity<TransactionDTO> addTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
		return ResponseEntity.ok(transactionService.addTransaction(transactionDTO));
	}
	
	@DeleteMapping("/transaction")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String removeTransaction(@RequestParam long transactionId) {
		transactionService.removeTransaction(transactionId);
		return "Transaction Deleted";		
	}
	
	@GetMapping("/transaction")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<TransactionDTO> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/transaction/{accountId}")
	@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
	public List<TransactionDTO> getAllAccountTransaction(@PathVariable long accountId){
		return transactionService.getAllAccountTransactions(accountId);
	}

}
