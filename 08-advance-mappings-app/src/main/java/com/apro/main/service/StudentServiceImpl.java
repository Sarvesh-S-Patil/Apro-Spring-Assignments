package com.apro.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Address;
import com.apro.main.entity.Student;
import com.apro.main.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);

	}

	@Override
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		 return studentRepository.findAll().stream()
		            .map(this::convertToDTO)  
		            .collect(Collectors.toList());
	}
	
	private StudentDTO convertToDTO(Student student) {
	    StudentDTO dto = new StudentDTO();
	    dto.setRollNumber(student.getRollNumber());
	    dto.setName(student.getName());
	    dto.setEmail(student.getEmail());
	    dto.setAge(student.getAge());
	    return dto;
	}

	@Override
	public Address getAddress(int rollnumber,String city) {
		Optional<Student> optionalStudent = studentRepository.findById(rollnumber);
		Student dbStudent = null;
		if(!optionalStudent.isPresent()) {
			return null;
		}
		dbStudent = optionalStudent.get();
		if(city != null) {
			dbStudent.getAddress().setCity(city);
			studentRepository.save(dbStudent);
		}
		return dbStudent.getAddress();
	}

}
