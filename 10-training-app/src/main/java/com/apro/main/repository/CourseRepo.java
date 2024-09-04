package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Course;
import com.apro.main.entity.Student;

import java.util.List;



@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	@Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseId = :courseId")
	List<Student> findStudentsByCourseId(@Param("courseId") int courseId);
}
