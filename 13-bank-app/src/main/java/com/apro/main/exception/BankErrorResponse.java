package com.apro.main.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BankErrorResponse {
	
	private int statusCode;
	private String errorMessage;
	private long timestamp;
}
