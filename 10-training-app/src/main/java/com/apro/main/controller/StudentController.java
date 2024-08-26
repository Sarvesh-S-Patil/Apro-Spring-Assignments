package com.apro.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students")
	public List<StudentDTO> getAllStudents(){
		
		return studentService.getAllStudents();
	
	}
	
	@GetMapping("/students/address")
	public Address getAddress(@RequestParam int rollNumber,@RequestParam (required = false) String city) {
		return studentService.getAddress(rollNumber,city);
	}
	


	
	
}
