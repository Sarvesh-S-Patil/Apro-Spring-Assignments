package com.apro.main.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer > {
	
	Page<Student> findByAge(int age,Pageable pageable);
}
