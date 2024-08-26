package com.apro.main.service;

import java.util.List;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;

public interface CourseService{
	
	public Course addCourse(CourseDTO courseDTO);
	
	public Course addInstructor(int courseId,Instructor instructor);
	

}
