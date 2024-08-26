package com.apro.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;
import com.apro.main.repository.CourseRepo;
import com.apro.main.repository.InstructorRepo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	InstructorRepo instructorRepo;
	
	public Course addCourse(CourseDTO courseDTO) {
		Course course = new Course();
		course.setCourseId(courseDTO.getCourseId());
		course.setCourseName(courseDTO.getCourseName());
		course.setDuration(courseDTO.getDuration());
		course.setFees(courseDTO.getFees());
		return courseRepo.save(course);
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



}
