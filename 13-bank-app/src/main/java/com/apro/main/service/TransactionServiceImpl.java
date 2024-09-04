package com.apro.main.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.TransactionDTO;
import com.apro.main.entity.Account;
import com.apro.main.entity.Customer;
import com.apro.main.entity.Transaction;
import com.apro.main.entity.TransactionType;
import com.apro.main.entity.User;
import com.apro.main.exception.AccountNotFoundException;
import com.apro.main.exception.CustomerNotFoundException;
import com.apro.main.exception.InsufficientBalanceException;
import com.apro.main.exception.InvalidAccountException;
import com.apro.main.exception.UserApiException;
import com.apro.main.repository.AccountRepository;
import com.apro.main.repository.CustomerRepository;
import com.apro.main.repository.TransactionRepository;
import com.apro.main.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepo;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		boolean transactionResult = false;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		boolean user_exists = userRepository.existsByUserName(username);
		if(user_exists==false)
			throw new UserApiException();
		User user = userRepository.findByUserName(username).get();
		if(user == null) throw new UserApiException();
		System.out.println(user);
		Customer customer = customerRepository.findByUser(user);
		if(customer==null) throw new CustomerNotFoundException();
		List<Account> accounts = customer.getAccounts();
		
		
		if(transactionDTO.getTransactionType() == TransactionType.CREDIT) {
			Account account = accountRepository.findById(transactionDTO.getRecieverAccountId()).orElseThrow(() -> new AccountNotFoundException());
			boolean valid_account = accounts.contains(account);
			if(valid_account==false)
				throw new UserApiException();
			transactionResult = credit(transactionDTO);
		}
		else if(transactionDTO.getTransactionType() == TransactionType.DEBIT ) {
			Account account = accountRepository.findById(transactionDTO.getSenderAccountId()).orElseThrow(() -> new AccountNotFoundException());
			boolean valid_account = accounts.contains(account);
			if(valid_account==false)
				throw new UserApiException();
			transactionResult = debit(transactionDTO);
		}
		else {
			Account account = accountRepository.findById(transactionDTO.getSenderAccountId()).orElseThrow(() -> new AccountNotFoundException());
			boolean valid_account = accounts.contains(account);
			if(valid_account==false)
				throw new UserApiException();
			transactionResult= transfer(transactionDTO);
		}
		transactionDTO.setTransactionStatus(transactionResult);
		return transactionDTO;
	}

	@Override
	public void removeTransaction(Long transactionId) {
		// TODO Auto-generated method stub
		transactionRepo.deleteById(transactionId);
		
	}
	
	@Transactional
	public boolean credit(TransactionDTO transactionDTO) {
		long recieverAccountId = transactionDTO.getRecieverAccountId();
		double amount = transactionDTO.getAmount();
		Transaction transaction = TransactionDTO.toTransactionMapper(transactionDTO);
		if(transactionDTO.getTransactionType() != TransactionType.TRANSFER) {
			transaction.setSenderAccountId(0);
		}		
			Account account = accountRepository.findById(recieverAccountId).orElseThrow(()-> new AccountNotFoundException());
			double currentBalance = account.getBalance();
			account.setBalance(currentBalance+amount);
			List<Transaction> transactions = account.getTransactions();
			if(transactions == null)
				transactions = new ArrayList<>();
			Transaction transactionDB = transactionRepo.save(transaction);
			transactions.add(transactionDB);
			account.setTransactions(transactions);
			accountRepository.save(account);
			
		return true;
	}
	

	@Transactional
	public boolean debit(TransactionDTO transactionDTO) {
	    long senderAccountId = transactionDTO.getSenderAccountId();
	    double amount = transactionDTO.getAmount();
	    Transaction transaction = TransactionDTO.toTransactionMapper(transactionDTO);
	       
	    Account senderAccount = accountRepository.findById(senderAccountId)
	            .orElseThrow(() -> new AccountNotFoundException());
	    if(transactionDTO.getTransactionType() != TransactionType.TRANSFER) {
			transaction.setRecieverAccountId(0);
		}	
	       
	        double currentBalance = senderAccount.getBalance();
	        if (currentBalance - amount < 0) {
	            throw new InsufficientBalanceException();
	        }

	        senderAccount.setBalance(currentBalance - amount);

	        transactionRepo.save(transaction);

	
	        List<Transaction> transactions = senderAccount.getTransactions();
	        if (transactions == null) {
	            transactions = new ArrayList<>();
	        }
	        transactions.add(transaction);
	        senderAccount.setTransactions(transactions);


	        accountRepository.save(senderAccount);

	        return true;
	}

	
	@Transactional
	public boolean transfer(TransactionDTO transactionDTO) {
		if(transactionDTO.getSenderAccountId() == transactionDTO.getRecieverAccountId())
			throw new InvalidAccountException();
		boolean debit_result = debit(transactionDTO);
		boolean credit_result = credit(transactionDTO);
		if(debit_result== false || credit_result==false)
			return false;
		return true;
	}

	@Override
	public TransactionDTO getTransaction(Long transactionId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Optional<Transaction> transaction = transactionRepo.findById(transactionId);
		if(transaction.isPresent())
			return TransactionDTO.toTransactionDTOMapper(transaction.get());
		return null;
		
	}

	@Override
	public List<TransactionDTO> getAllTransactions() {
		// TODO Auto-generated method stub
		List<Transaction> transactions = transactionRepo.findAll();
		List<TransactionDTO> transactionsDTO = new ArrayList<>();
		transactions.forEach((transaction)->
		{
			transactionsDTO.add(TransactionDTO.toTransactionDTOMapper(transaction));
		}
				);
		return transactionsDTO;
	}

	@Override
	public List<TransactionDTO> getAllAccountTransactions(long accountId) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(accountId).orElseThrow(()-> new AccountNotFoundException());
		List<Transaction> transactions = account.getTransactions();
		List<TransactionDTO> transactionsDTO = new ArrayList<>();
		transactions.forEach((transaction)->
		{
			transactionsDTO.add(TransactionDTO.toTransactionDTOMapper(transaction));
		}
		);
		return transactionsDTO;
	}

}
