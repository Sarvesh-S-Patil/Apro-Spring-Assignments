package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.apro.main.DTO.AccountDTO;
import com.apro.main.service.AccountService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/bank-app")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public AccountDTO getAccountById(@RequestParam Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/accounts")
	@PreAuthorize("hasRole('ADMIN')")
    public AccountDTO addAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return accountService.addAccount(accountDTO);
    }

    @DeleteMapping("/accounts")
	@PreAuthorize("hasRole('ADMIN')")
    public String deleteAccount(@RequestParam Long id) {
        accountService.removeAccount(id);
        return "Account Deleted Successfully";
    }

   
}
