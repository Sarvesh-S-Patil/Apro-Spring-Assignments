package com.apro.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="employee_jpa")
public class Employee {
	@Id
	@Column
	@NotNull(message = "employee id cannot be empty")
	@Min(value = 1, message = "Employee ID must be a positive number")
	private int employeeId;
	
	@Column
	@NotBlank(message = "first name cannot be empty")
	private String firstName;
	
	@Column
	@NotBlank(message = "last name cannot be empty")
	private String lastName;
	
	@Column
	@NotNull(message = "phone number cannot be empty")
	@Min(value = 1000000000L, message = "Phone number must be at least 10 digits long")
	@Max(value = 9999999999L, message = "Phone number must be no more than 10 digits long")
	private long phoneNumber;
	
	@Column
	@Email(message = "email is not valid")
	@NotBlank(message="email cannot be empty")
	private String email;
	
	@Column
	@NotBlank(message="position cannot be empty")
	private String position;
	
	@Column
	@NotNull(message="salary cannot be empty")

	private double salary;
	
	@Column
	@Min(value = 1000000000L, message = "Bank account number must be at least 10 digits long")
	@Max(value = 9999999999L, message = "Bank account number must be no more than 10 digits long")
	@NotNull(message="bankAccountNumber cannot be empty")
	private long bankAccountNumber;
	
	@Column
	@NotNull(message="bankIfsc number cannot be empty")
	private long bankIfscNumber;
	
	@Column
	@Enumerated(EnumType.STRING)
	@NotNull(message="employee status cannot be empty")
	private EmployeeStatus employeeStatus;

}
