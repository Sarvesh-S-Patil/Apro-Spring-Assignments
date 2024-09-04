package com.apro.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Student;
import com.apro.main.entity.Course;
import java.util.Set;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseId = :courseId")
	List<Student> findStudentsByCourseId(@Param("courseId") int courseId);

}
