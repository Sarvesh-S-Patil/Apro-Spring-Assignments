package com.apro.main.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.DTO.InstructorDTO;
import com.apro.main.DTO.PageResponse;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;


public interface InstructorService {
	public InstructorDTO addInstructor(InstructorDTO instructorDTO);
	
	public Instructor allocateCourses(int instructorId,List<Course> course);
	
	public List<CourseDTO> getInstructorCourses(int instructorId);
	
	public PageResponse<InstructorDTO> getAllInstructors(int pageNumber,int pageSize);
	
	public InstructorDTO getInstructor(int instructorId);
			
}
