package com.apro.main.service;



import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.CourseDTO;
import com.apro.main.DTO.InstructorDTO;
import com.apro.main.DTO.PageResponse;
import com.apro.main.entity.Course;
import com.apro.main.entity.Instructor;
import com.apro.main.repository.CourseRepo;
import com.apro.main.repository.InstructorRepo;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepo instructorRepo;
	@Autowired 
	CourseRepo courseRepo;
	@Override
	public InstructorDTO addInstructor(InstructorDTO instructorDTO) {
		Instructor instructor = InstructorDTO.toInstructorMapper(instructorDTO);
		Instructor instructorDB = instructorRepo.save(instructor);
		InstructorDTO  instructorDbDTO = InstructorDTO.toInstructorDTOMapper(instructorDB);
		return instructorDbDTO;
	}
	@Override
	public Instructor allocateCourses(int instructorId,List<Course> courses) {
		Instructor instructor ;
		Optional<Instructor> optionalInstructor  =instructorRepo.findById(instructorId);
		if(!optionalInstructor.isPresent()) {
			return null;
		}
		instructor=optionalInstructor.get();
		List<Course> dbCourses = instructor.getCourses();
		courses.forEach(
				(course)-> {
					Course temp = courseRepo.findById(course.getCourseId()).get();
					temp.setInstructor(instructor);
					dbCourses.add(temp);
				}
				
		);
		instructor.setCourses(dbCourses);
		return instructorRepo.save(instructor);
	}
	
	

	@Override
	public List<CourseDTO> getInstructorCourses(int instructorId) {
		// TODO Auto-generated method stub
		Optional<Instructor> instructor = instructorRepo.findById(instructorId);
		if(instructor.isEmpty())
			return null;
		List<Course> courses = instructor.get().getCourses();
		List<CourseDTO> coursesDTO = new ArrayList<>();
		for( Course course : courses) {
			coursesDTO.add(CourseDTO.toCourseDTOMapper(course));
		}
		return coursesDTO;
	}
	@Override
	public PageResponse<InstructorDTO> getAllInstructors(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Instructor> instructorPage = instructorRepo.findAll(pageable);
		Page<InstructorDTO> instructorDtoPage = instructorPage.map(InstructorDTO::toInstructorDTOMapper);
		PageResponse pageResponse = new PageResponse<>(instructorDtoPage);
		return pageResponse;
	}
	@Override
	public InstructorDTO getInstructor(int instructorId) {
		// TODO Auto-generated method stub
		Optional<Instructor> optionalInstructor = instructorRepo.findById(instructorId);
		if(optionalInstructor.isEmpty())
			return null;
		return InstructorDTO.toInstructorDTOMapper(optionalInstructor.get());
	}
	
	
	
	

}
