package com.apro.main.service;

import java.util.List;

import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Address;
import com.apro.main.entity.Student;

public interface StudentService {
	public Student addStudent(Student student);
	
	public List<StudentDTO> getAllStudents();
	
	public Address getAddress(int rollnumber,String city);
}
