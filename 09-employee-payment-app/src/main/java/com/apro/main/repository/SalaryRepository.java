package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Salary;

public interface SalaryRepository  extends JpaRepository<Salary, Long>{

}
