package com.apro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Loan;
import com.apro.main.repository.LoanRepo;


@Service
public class LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	
	public List<Loan> getAllLoans(){
		return loanRepo.getAllLoans();
	}
	
	public void addLoan(Loan loan) {
		loanRepo.addLoan(loan);
	}
	
	public Loan getLoanById(int loanId) {
		return loanRepo.getLoanById(loanId);
	}
	
	public List<Loan> getLoanByStatus(String loanStatus){
		return loanRepo.getLoanByStatus(loanStatus);
	}
	
	public void deleteLoan(int loanId) {
		loanRepo.deleteLoan(loanId);
	}
}
