package com.apro.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="instructor")
public class Instructor {
	@Column
	@Id
	private int instructorId;
	@Column
	private String instructorName;
	
	@Column
	private String email;
	@Column
	private String qualification;
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private List<Course> courses;
}
