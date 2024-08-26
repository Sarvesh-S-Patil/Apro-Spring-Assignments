package com.apro.main.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long employeeId;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	long phoneNumber;
	@Column
	String email;
	@Column
	String position;
	@Column
	LocalDate hireDate;
	@Column
	double salary;
	@Column
	long accountNumber;
	@Column
	@Enumerated(EnumType.STRING)
	EmployeeStatus status;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="clientId")
	Client client;

}
