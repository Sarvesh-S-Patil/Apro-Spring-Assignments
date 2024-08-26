package com.apro.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.PageResponse;
import com.apro.main.entity.Student;
import com.apro.main.service.StudentService;

@RestController
@RequestMapping("/student-app")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public PageResponse<Student> getAllStudents(@RequestParam int pageNo,@RequestParam int pageSize){
		
		return  studentService.getAllStudents(pageNo, pageSize);
	}
	
	@GetMapping("/students/find")
	public Page<Student> getAllStudents(@RequestParam int age,@RequestParam int pageNo,@RequestParam int pageSize){
		return  studentService.getStudentByAge(age,pageNo,pageSize);
	}
	
	@GetMapping("/students/{rollNumber}")
	public Optional<Student> getStudentByRollNumber(@PathVariable int rollNumber) {
		return studentService.getByRollNumber(rollNumber);
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added successfully";
	}
	
	@DeleteMapping("/students/{rollNumber}")
	public String deleteStudent(@PathVariable int rollNumber) {
		Optional<Student> student = studentService.getByRollNumber(rollNumber);
		if(student != null) {
			studentService.deleteStudent(rollNumber);
		}
		return "Student deleted successfully";
	}
	
}
