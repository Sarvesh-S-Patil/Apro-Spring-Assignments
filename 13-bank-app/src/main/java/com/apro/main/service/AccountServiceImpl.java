package com.apro.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.AccountDTO;
import com.apro.main.entity.Account;
import com.apro.main.entity.Customer;
import com.apro.main.entity.User;
import com.apro.main.exception.AccountNotFoundException;
import com.apro.main.exception.CustomerNotFoundException;
import com.apro.main.exception.UserApiException;
import com.apro.main.repository.AccountRepository;
import com.apro.main.repository.CustomerRepository;
import com.apro.main.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private CustomerRepository customerRepository;
	@Autowired
	UserRepository userRepository;

    @Override
    @Transactional
    public AccountDTO addAccount(AccountDTO accountDTO) {
		
		Customer customer = customerRepository.findById(accountDTO.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException());
        Account account = AccountDTO.toAccountMapper(accountDTO);
        account.setAccountId(generateUniqueId());
       
        account.setCustomer(customer);
        account.setFirstName(customer.getFirstName());
        account.setLastName(customer.getLastName());
        account.setEmailAddress(customer.getEmail());
        Account accountDb = accountRepo.save(account);
        List<Account> accounts = customer.getAccounts();
        if(accounts == null)
        	accounts = new ArrayList<>();
        accounts.add(accountDb);
        customer.setAccounts(accounts);
        customerRepository.save(customer);
        return AccountDTO.toAccountDTOMapper(accountDb);
    }

    @Override
    public AccountDTO getAccount(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException());
        return AccountDTO.toAccountDTOMapper(account);
    }

    @Override
    public void removeAccount(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException());
        accountRepo.delete(account);
    }
    


    private static final long MIN_ID = 10000000000L; 
    private static final long MAX_ID = 99999999999L; 
    private static final Random random = new Random();

    public long generateUniqueId() {
        long newId;
        do {
            newId = MIN_ID + (long) (random.nextDouble() * (MAX_ID - MIN_ID + 1));
        } while (accountRepo.existsByAccountId(newId));
        return newId;
    }




}
