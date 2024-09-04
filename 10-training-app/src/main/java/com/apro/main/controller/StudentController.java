package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.PageResponse;
import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Address;
import com.apro.main.entity.Student;
import com.apro.main.service.StudentService;


@RestController
@RequestMapping("/student-app")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/students")
	public StudentDTO addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students")
	public PageResponse<StudentDTO> getAllStudents(@RequestParam int pageNumber,@RequestParam int pageSize){
		return studentService.getAllStudents(pageNumber,pageSize);
	}
	
	@GetMapping("/students/{rollNumber}")
	public ResponseEntity<StudentDTO> getStudentByRollNumber(@PathVariable int rollNumber){
		return ResponseEntity.ok(studentService.getStudentByRollNumber(rollNumber));
	}
	
	@GetMapping("/students/address")
	public Address getAddress(@RequestParam int rollNumber,@RequestParam (required = false) String city) {
		return studentService.getAddress(rollNumber,city);
	}
	
	
	@PostMapping("/students/assign-courses")
	public StudentDTO assignStudentCourses(@RequestParam int rollNumber,@RequestBody List<Integer> courseIds) {
		return studentService.assignCourses(rollNumber	, courseIds);
	}

	
	
}
