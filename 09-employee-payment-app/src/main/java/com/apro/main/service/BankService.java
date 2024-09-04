package com.apro.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Bank;
import com.apro.main.entity.SalaryAccount;
import com.apro.main.repository.BankRepository;
import com.apro.main.repository.SalaryAccountRepository;

@Service
public class BankService {
	@Autowired
	BankRepository bankRepository;
	@Autowired
	SalaryAccountRepository salaryAccountRepository;
	
	public Bank addBank(Bank bank) {
		 return bankRepository.save(bank);
	}
	
	public Bank getBankById(long bankId) {
		Optional<Bank> optionalBank = bankRepository.findById(bankId);
		if(!optionalBank.isPresent())
			return null;
		return optionalBank.get();
	}
	
	public Bank addNewBankAccount(long bankId,SalaryAccount account) {
		Bank bank = bankRepository.findById(bankId).get();
		if(bank == null)
			return null;
		List<SalaryAccount> accounts = bank.getAccounts();
//		SalaryAccount salaryAccount =salaryAccountRepository.save(account);
		
		account.setBank(bank);
		accounts.add(account);
		bank.setAccounts(accounts);
		salaryAccountRepository.save(account);
		return bankRepository.save(bank);
	}
}
