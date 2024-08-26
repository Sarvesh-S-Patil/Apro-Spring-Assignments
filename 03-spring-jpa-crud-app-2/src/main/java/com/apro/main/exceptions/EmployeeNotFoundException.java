package com.apro.main.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
	public String getMessage() {
		return "Employee not found";
	}
}
