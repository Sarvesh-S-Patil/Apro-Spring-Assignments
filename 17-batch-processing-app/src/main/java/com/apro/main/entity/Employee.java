package com.apro.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	@Id
	@Column
	int employeeId;
	
	@Column
	String name;
	
	@Column
	String salary;
}
