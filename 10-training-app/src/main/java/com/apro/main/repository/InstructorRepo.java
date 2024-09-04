package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
	
}
