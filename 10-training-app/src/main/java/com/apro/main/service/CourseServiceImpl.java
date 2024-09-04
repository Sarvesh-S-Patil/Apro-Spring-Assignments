package com.apro.main.service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.DTO.StudentDTO;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;
import com.apro.main.entity.Student;
import com.apro.main.repository.CourseRepo;
import com.apro.main.repository.InstructorRepo;
import com.apro.main.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	InstructorRepo instructorRepo;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	public Course addCourse(CourseDTO courseDTO) {
		Course course = new Course();
		course.setCourseId(courseDTO.getCourseId());
		course.setCourseName(courseDTO.getCourseName());
		course.setDuration(courseDTO.getDuration());
		course.setFees(courseDTO.getFees());
		Course courseDB = courseRepo.save(course);
		logger.info("Course added successfully");
		return courseDB;
	}

	@Override
	public Course addInstructor(int courseId,Instructor instructor) {
		// TODO Auto-generated method stub
		Course course ;
		Optional<Course> optionalCourse = courseRepo.findById(courseId) ;
		if(!optionalCourse.isPresent())
			return null;
		course=optionalCourse.get();
		Optional<Instructor> optionalInstructorDB = instructorRepo.findById(instructor.getInstructorId());
		if(!optionalInstructorDB.isPresent())
			return null;
		Instructor instructorDb = optionalInstructorDB.get();
		course.setInstructor(instructorDb);
		
		return courseRepo.save(course);
	}

	@Override
	public CourseDTO assignStudents(int courseId, List<Integer> studentIds) {
		// TODO Auto-generated method stub
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new NullPointerException() );
		List<Student> students = course.getStudents();
		if(students==null)
			students= new ArrayList<Student>();
		List<Student> studentsToAdd= new ArrayList<Student>();
		studentIds.forEach( 
				(studentId) ->{
					Student studentDb = studentRepository.findById(studentId).orElseThrow(()-> new NullPointerException());
					Set<Course> courses = studentDb.getCourses();
					if(courses==null)
						courses= new HashSet<Course>();
					courses.add(course);
					studentsToAdd.add(studentDb);
				}
				);
		students.addAll(studentsToAdd);
		return CourseDTO.toCourseDTOMapper(courseRepo.save(course));
	}
	
	public List<StudentDTO> findStudentsbyCourse(int courseId){
		List<Student> students  = studentRepository.findStudentsByCourseId(courseId);
		List<StudentDTO> studentsDTO = new ArrayList<>();
		students.forEach( (student) -> studentsDTO.add( StudentDTO.toStudentDTOMapper(student)));
		students.forEach((student)->System.out.println(student.getRollNumber()));
		return studentsDTO;
		
	}



}
