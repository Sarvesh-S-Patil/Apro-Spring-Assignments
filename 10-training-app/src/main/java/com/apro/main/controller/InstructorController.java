package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.DTO.InstructorDTO;
import com.apro.main.DTO.PageResponse;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;
import com.apro.main.service.InstructorService;

@RestController
@RequestMapping("/student-app")
public class InstructorController {
	@Autowired
	InstructorService instructorService;
	
	@PostMapping("/instructors")
	public InstructorDTO addInstructor(@RequestBody InstructorDTO instructorDTO) {
		return instructorService.addInstructor(instructorDTO);
	}

	@PostMapping("/instructors/courses/add")
	public Instructor allocateCourses(@RequestParam int instructorId,@RequestBody List<Course> courses) {
		return instructorService.allocateCourses(instructorId, courses);
	}
	
	@GetMapping("/instructors/courses")
	public List<CourseDTO> getInstructorCourse(@RequestParam int instructorId){
		return instructorService.getInstructorCourses(instructorId);
	}
	
	@GetMapping("/instructors")
	public PageResponse<InstructorDTO> getInstructors(@RequestParam int pageNumber,@RequestParam int pageSize){
		return instructorService.getAllInstructors(pageNumber, pageSize);  
	}
	
	@GetMapping("/instructors/{instructorId}")
	public InstructorDTO getInstructor(@PathVariable int instructorId) {
		return instructorService.getInstructor(instructorId);
	}
	
}
