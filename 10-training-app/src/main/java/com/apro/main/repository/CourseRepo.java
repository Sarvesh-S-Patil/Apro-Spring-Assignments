package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Course;


@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
