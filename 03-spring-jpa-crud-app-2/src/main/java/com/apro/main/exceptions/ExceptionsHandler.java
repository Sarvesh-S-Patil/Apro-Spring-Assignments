package com.apro.main.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentException){
		Map<String,String> errors = new HashMap<>();
		methodArgumentException.getBindingResult().getFieldErrors().forEach(
				(error) -> {
					errors.put(error.getField(), error.getDefaultMessage());
				}
				);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleClientNotFoundException(ClientNotfoundException clientNotfoundException){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(clientNotfoundException.getMessage());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(employeeNotFoundException.getMessage());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
}
