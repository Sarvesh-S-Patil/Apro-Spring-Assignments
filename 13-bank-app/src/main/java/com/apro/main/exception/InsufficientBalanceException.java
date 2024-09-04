package com.apro.main.exception;

public class InsufficientBalanceException extends RuntimeException {
	
	public String getMessage() {
		return "You don't have sufficient funds to perform this transaction";
	}

}
