package com.apro.main.service;

import java.util.List;

import com.apro.main.DTO.PageResponse;
import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Address;
import com.apro.main.entity.Student;

public interface StudentService {

	
	public PageResponse<StudentDTO> getAllStudents(int pageNumber,int pageSize);
	
	public Address getAddress(int rollnumber,String city);
	
	public StudentDTO addStudent(Student studentDto);
	
	public StudentDTO getStudentByRollNumber(int rollNumber);
	
	
	public StudentDTO assignCourses(int rollNumber,List<Integer> courseIds);
}
