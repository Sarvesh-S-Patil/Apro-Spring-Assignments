package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;
import com.apro.main.service.CourseService;

@RestController
@RequestMapping("/student-app")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.addCourse(courseDTO);
	}
	
	@PostMapping("/course/instructor/add")
	public Course allocateInstructor(@RequestParam int  courseId,@RequestBody Instructor instructor) {
		return courseService.addInstructor(courseId, instructor);
	}
	
}
