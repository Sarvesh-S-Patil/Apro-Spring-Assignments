package com.apro.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Table(name="student")
@Entity



public class Student {
	@Id
	@Column(name="rollNumber")
	private int rollNumber;
	
	@Column(name="name")
	@NotBlank(message = "Name cannot be null")
	private String name;
	
	@Column(name="age")
	@Min(18)
	private int age;

	
}
