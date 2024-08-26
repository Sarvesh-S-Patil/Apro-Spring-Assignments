package com.apro.main.exception;

public class StudentNotFoundException  extends RuntimeException{
	
	public String getMessage() {
		return "Student you are seacrching cannot be found";
	}
}
