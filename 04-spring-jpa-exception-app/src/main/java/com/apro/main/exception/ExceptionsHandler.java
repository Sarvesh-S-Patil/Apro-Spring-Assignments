package com.apro.main.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apro.main.error.StudentErrorResponse;


@ControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFoundException notFoundException){
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setErrorMessage(notFoundException.getMessage());
		studentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
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
}
