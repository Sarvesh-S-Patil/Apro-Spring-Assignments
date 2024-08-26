package com.apro.main.DTO;


import com.apro.main.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	private int courseId;
	private String courseName;
	private int duration;
	private double fees;
	

	public static CourseDTO toCourseDTOMapper(Course course) {
		// TODO Auto-generated method stub
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setCourseId(course.getCourseId());
		courseDTO.setCourseName(course.getCourseName());
		courseDTO.setDuration(course.getDuration());
		courseDTO.setFees(course.getFees());
		return courseDTO;
	}


	public static Course toCourseMapper(CourseDTO courseDTO) {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setCourseId(courseDTO.getCourseId());
		course.setCourseName(courseDTO.getCourseName());
		course.setDuration(courseDTO.getDuration());
		course.setFees(courseDTO.getFees());
		return course;
	}
}
