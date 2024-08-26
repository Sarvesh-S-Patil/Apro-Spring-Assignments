package com.apro.main.entity;


import org.springframework.context.annotation.Lazy;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNumber;
	@Column
	private String name;
	@Column
	private String email;	
	@Column
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

}
