package com.apro.main.exceptions;

public class ClientNotfoundException extends RuntimeException{
	
	public String getMessage() {
		return "Client cannot be found";
	}

}
