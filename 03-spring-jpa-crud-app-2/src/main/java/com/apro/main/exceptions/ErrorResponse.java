package com.apro.main.exceptions;

import lombok.Data;
import lombok.Getter;

@Data
public class ErrorResponse{
	private int statusCode;
	private String errorMessage;
	private long timestamp;
	

}
