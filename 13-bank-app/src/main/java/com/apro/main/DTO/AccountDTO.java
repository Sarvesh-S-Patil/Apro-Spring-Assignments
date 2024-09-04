package com.apro.main.DTO;



import com.apro.main.entity.Account;
import com.apro.main.exception.CustomerNotFoundException;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDTO {
	long accountId;
	
	long customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @NotNull
    @DecimalMin(value="0.0",message = "Balance must be a non-negative number.")
    private double balance;
	
	public static AccountDTO toAccountDTOMapper(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(account.getAccountId());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setEmailAddress(account.getEmailAddress() );
		accountDTO.setFirstName(account.getFirstName());
		accountDTO.setLastName(account.getLastName());
		accountDTO.setCustomerId(account.getCustomer()==null ? 0 : account.getCustomer().getCustomerId() );
		return accountDTO;
	}
	
	public static Account toAccountMapper(AccountDTO accountDTO) {
		Account account = new Account();
		account.setAccountId(accountDTO.getAccountId());
		account.setBalance(accountDTO.getBalance());
		account.setEmailAddress(accountDTO.getEmailAddress() );
		account.setFirstName(accountDTO.getFirstName());
		account.setLastName(accountDTO.getLastName());
		
		return account;
	}

}
