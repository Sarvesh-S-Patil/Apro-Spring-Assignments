package com.apro.main.exception;

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
	
	 @ExceptionHandler(UserApiException.class)
	    public ResponseEntity<BankErrorResponse> handleUserApiException(UserApiException ex) {
	        BankErrorResponse bankErrorResponse = new BankErrorResponse();
	        bankErrorResponse.setErrorMessage(ex.getMessage());
	        bankErrorResponse.setStatusCode(ex.getStatus().value());
	        bankErrorResponse.setTimestamp(System.currentTimeMillis());
	        return new ResponseEntity<>(bankErrorResponse, ex.getStatus());
	    }
	 @ExceptionHandler(AccountNotFoundException.class)
		public ResponseEntity<BankErrorResponse> handleAccountNotFound(AccountNotFoundException notFoundException){
			BankErrorResponse bankErrorResponse = new BankErrorResponse();
			bankErrorResponse.setErrorMessage(notFoundException.getMessage());
			bankErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			bankErrorResponse.setTimestamp(System.currentTimeMillis());
			return new ResponseEntity<>(bankErrorResponse,HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<BankErrorResponse> handleCustomerNotFound(CustomerNotFoundException notFoundException){
	    BankErrorResponse bankErrorResponse = new BankErrorResponse();
	    bankErrorResponse.setErrorMessage(notFoundException.getMessage());
	    bankErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
	    bankErrorResponse.setTimestamp(System.currentTimeMillis());
	    return new ResponseEntity<>(bankErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<BankErrorResponse> handleInsufficientBalance(InsufficientBalanceException notFoundException){
	    BankErrorResponse bankErrorResponse = new BankErrorResponse();
	    bankErrorResponse.setErrorMessage(notFoundException.getMessage());
	    bankErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    bankErrorResponse.setTimestamp(System.currentTimeMillis());
	    return new ResponseEntity<>(bankErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<BankErrorResponse> handleInvalidAccount(InvalidAccountException notFoundException){
	    BankErrorResponse bankErrorResponse = new BankErrorResponse();
	    bankErrorResponse.setErrorMessage(notFoundException.getMessage());
	    bankErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    bankErrorResponse.setTimestamp(System.currentTimeMillis());
	    return new ResponseEntity<>(bankErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<BankErrorResponse> handleUserNotFound(UserNotFoundException notFoundException){
	    BankErrorResponse bankErrorResponse = new BankErrorResponse();
	    bankErrorResponse.setErrorMessage(notFoundException.getMessage());
	    bankErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
	    bankErrorResponse.setTimestamp(System.currentTimeMillis());
	    return new ResponseEntity<>(bankErrorResponse, HttpStatus.NOT_FOUND);
	}


}
