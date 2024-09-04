package com.apro.main.service;

import java.util.List;

import com.apro.main.DTO.TransactionDTO;

public interface TransactionService {
	public TransactionDTO addTransaction(TransactionDTO transactionDTO);
	public TransactionDTO getTransaction(Long transactionId);
	public void  removeTransaction(Long transactionId);
	public List<TransactionDTO> getAllTransactions();
	
	public List<TransactionDTO> getAllAccountTransactions(long accountId);
}
