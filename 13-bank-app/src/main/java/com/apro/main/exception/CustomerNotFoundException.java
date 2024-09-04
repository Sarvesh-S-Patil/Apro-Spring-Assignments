package com.apro.main.exception;

public class CustomerNotFoundException extends RuntimeException{
		
	
	public String getMessage() {
		return "Customer with ID cannot be found "; 
	}
}
