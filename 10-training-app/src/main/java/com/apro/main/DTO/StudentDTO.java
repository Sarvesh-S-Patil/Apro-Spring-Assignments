package com.apro.main.DTO;

import com.apro.main.entity.Student;

import lombok.Data;

@Data
public class StudentDTO {
	
	private int rollNumber;
	private String name;
	private String email;	
	private int age;
	
	public static StudentDTO toStudentDTOMapper(Student student) {
		StudentDTO studentDto = new StudentDTO();
		studentDto.rollNumber= student.getRollNumber();
		studentDto.name=student.getName();
		studentDto.email=student.getEmail();
		studentDto.age=student.getAge();
		return studentDto;
	}
	
	
	public static Student toStudentMapper(StudentDTO studentDto) {
		Student student = new Student();
		student.setRollNumber(studentDto.getRollNumber());
		student.setName( studentDto.getName() );
		student.setEmail( studentDto.getEmail());
		student.setAge(studentDto.getAge());
		return student;
	}

}
