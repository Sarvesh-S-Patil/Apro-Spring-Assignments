package com.apro.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="course")

public class Course {
	@Column
	@Id
	private int courseId;
	@Column
	private String courseName;
	@Column
	private int duration;
	@Column
	private double fees;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name = "instructorId")
	@JsonIgnore
	private Instructor instructor;

}
