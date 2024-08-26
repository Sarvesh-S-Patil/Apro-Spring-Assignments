package com.apro.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.PageResponse;
import com.apro.main.entity.Student;
import com.apro.main.exception.StudentNotFoundException;
import com.apro.main.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public PageResponse getAllStudents(int pageNo,int pageSize){
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> studentPage = studentRepository.findAll(pageable);
		PageResponse<Student> studentPageResponse = new PageResponse();
		studentPageResponse.setSize(studentPage.getSize());
		studentPageResponse.setTotalElements(studentPage.getSize());
		studentPageResponse.setTotalPages(studentPage.getTotalPages());
		studentPageResponse.setContent(studentPage.getContent());
		studentPageResponse.setLastPage(studentPage.isLast());
		return studentPageResponse;
	}
	
	public Student getByRollNumber(int rollNumber) {
		 Optional<Student> optionalStudent =  studentRepository.findById(rollNumber);
		if(!optionalStudent.isPresent()) {
			throw new StudentNotFoundException();
		}
		return optionalStudent.get();
	}
	
	public void addStudent( Student student) {
		studentRepository.save(student);
	}
	
	public Page<Student> getStudentByAge(int age, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return studentRepository.findByAge(age,pageable);
	}
	
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}
}
