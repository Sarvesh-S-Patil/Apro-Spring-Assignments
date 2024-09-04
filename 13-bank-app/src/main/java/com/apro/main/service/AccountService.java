package com.apro.main.service;

import com.apro.main.DTO.AccountDTO;

public interface AccountService {
	
	public AccountDTO addAccount(AccountDTO accountDTO);
	
	public AccountDTO getAccount(Long id);
	
	public void removeAccount(Long id);
}
