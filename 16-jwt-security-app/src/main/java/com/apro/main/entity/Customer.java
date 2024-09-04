package com.apro.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "customer")
@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class Customer {
	
	@Column
	@Id
	private int customerId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private long mobileNumber;

}
