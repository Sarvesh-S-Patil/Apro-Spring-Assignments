package com.apro.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Bank;
import com.apro.main.entity.SalaryAccount;
import com.apro.main.repository.BankRepository;
import com.apro.main.repository.SalaryAccountRepository;

@Service
public class SalaryAccountService {
	@Autowired
	SalaryAccountRepository salaryAccountRepository;
	@Autowired
	BankService bankService;
	
	public SalaryAccount getSalaryAccount(long accountNumber) {
		Optional<SalaryAccount> account = salaryAccountRepository.findById(accountNumber);
		if(account.isEmpty())
			return null;
		return account.get();
	}
	
	
	public SalaryAccount addSalaryAccount(SalaryAccount account) {
		return salaryAccountRepository.save(account);
	}
	
	public SalaryAccount setBank(long accountNumber,Bank bank) {
		Optional<SalaryAccount> optionalAccount = salaryAccountRepository.findById(accountNumber);
		if(optionalAccount.isEmpty())
			return null;
		SalaryAccount account = optionalAccount.get();
		Bank current_bank = bankService.getBankById(bank.getBankId());
		if(current_bank == null) {
			return null;
		}
		account.setBank(current_bank);
		return salaryAccountRepository.save(account);
		
		
	}
	
}
