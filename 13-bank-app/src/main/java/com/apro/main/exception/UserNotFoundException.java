package com.apro.main.exception;

public class UserNotFoundException extends RuntimeException {
	
	public String getMessage()
	{
		return "User with id cannot be found";
	}
}
