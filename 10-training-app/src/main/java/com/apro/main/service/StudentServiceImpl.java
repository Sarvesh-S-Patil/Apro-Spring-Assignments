package com.apro.main.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.PageResponse;
import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Address;
import com.apro.main.entity.Course;
import com.apro.main.entity.Student;
import com.apro.main.repository.CourseRepo;
import com.apro.main.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepo courseRepo;


	
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

	@Override
	public PageResponse<StudentDTO> getAllStudents(int pageNumber,int  pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentsPage = studentRepository.findAll(pageable);
		PageResponse<StudentDTO> studentsDtoPage = new PageResponse<>();
		studentsDtoPage.setTotalPages(studentsPage.getTotalPages());
		studentsDtoPage.setSize(studentsPage.getSize());
		studentsDtoPage.setTotalElements(studentsPage.getTotalElements());
		studentsDtoPage.setLastPage(studentsPage.isLast());
		
		List<StudentDTO> studentDtoList = new ArrayList<>();
		
		studentsPage.getContent().forEach(
				(student) ->studentDtoList.add(StudentDTO.toStudentDTOMapper(student) ));
		studentsDtoPage.setContent(studentDtoList);
		return studentsDtoPage;
	}

	@Override
	public StudentDTO addStudent(Student student) {
		// TODO Auto-generated method stub
		Student studentDb = studentRepository.save(student);
		return StudentDTO.toStudentDTOMapper(studentDb);
	}

	@Override
	public StudentDTO getStudentByRollNumber(int rollNumber) {	
		Student student = studentRepository.findById(rollNumber)
				.orElseThrow( () -> new NullPointerException() );	
		return StudentDTO.toStudentDTOMapper(student);
	}

	@Override
	public StudentDTO assignCourses(int rollNumber, List<Integer> courseIds) {
		Student student = studentRepository.findById(rollNumber).orElseThrow(()-> new NullPointerException());
		
		Set<Course> courses = student.getCourses();
		if(courses == null)
			courses = new HashSet<Course>();
		Set<Course> coursesToAdd = new HashSet<>();
		courseIds.forEach((courseId) -> 
			{
				Course courseDb = courseRepo.findById(courseId).orElseThrow(() -> new NullPointerException());
				List<Student> students = courseDb.getStudents();
				if(students == null)
					students = new ArrayList<Student>();
				students.add(student);
				coursesToAdd.add(courseDb);
			});
		
		courses.addAll(coursesToAdd);
		student.setCourses(courses);
		
		return StudentDTO.toStudentDTOMapper(studentRepository.save(student));
	}


}
