package com.apro.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.SalaryTransaction;
import com.apro.main.repository.SalaryTransactionRepository;

@Service
public class SalaryTransactionService {
	@Autowired
	SalaryTransactionRepository salaryTransactionRepository;
	
	
	public SalaryTransaction getTransaction(long transactionId) {
		Optional<SalaryTransaction> transaction = salaryTransactionRepository.findById(transactionId);
		if(transaction.isEmpty())
			return null;
		return transaction.get();
		
	}
	
	public SalaryTransaction addTransaction(SalaryTransaction salaryTransaction) {
		return salaryTransactionRepository.save(salaryTransaction);
	}
	
}
