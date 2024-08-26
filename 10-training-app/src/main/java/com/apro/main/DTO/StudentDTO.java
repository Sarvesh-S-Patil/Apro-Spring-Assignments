package com.apro.main.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentDTO {
	
	private int rollNumber;
	private String name;
	private String email;	
	private int age;

}
