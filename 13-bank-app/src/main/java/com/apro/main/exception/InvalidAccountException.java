package com.apro.main.exception;

public class InvalidAccountException extends RuntimeException{
	
	public String getmessage() {
		return "Account is invalid";
	}

}
