package com.apro.main.exception;

public class AccountNotFoundException  extends RuntimeException{
	
	public String getMessage() {
		return "Account with ID cannot be found";
	}

}
