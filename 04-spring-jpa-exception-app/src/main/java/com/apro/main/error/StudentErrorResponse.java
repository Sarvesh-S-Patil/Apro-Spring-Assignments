package com.apro.main.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentErrorResponse {
	
	private int statusCode;
	private String errorMessage;
	private long timestamp;

}
