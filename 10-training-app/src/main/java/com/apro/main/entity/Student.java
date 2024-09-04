package com.apro.main.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name="student-course" , joinColumns = @JoinColumn(name="rollNumber"), 
				inverseJoinColumns = @JoinColumn(name ="courseId") )
	private Set<Course> courses;

}
