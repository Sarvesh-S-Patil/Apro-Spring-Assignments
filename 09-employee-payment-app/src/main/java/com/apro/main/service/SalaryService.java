package com.apro.main.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Employee;
import com.apro.main.entity.Salary;
import com.apro.main.repository.SalaryRepository;

@Service
public class SalaryService {
	@Autowired
	SalaryRepository salaryRepository;
	
	public Salary addSalary(Salary salary) {
		 return salaryRepository.save(salary);
	}
	
	public void deleteSalaryById(long salaryId) {
		salaryRepository.deleteById(salaryId);
	}
	
	public Salary getSalaryById(long salaryId) {
		 Optional<Salary> optionalSalary =salaryRepository.findById(salaryId);
		 if(!optionalSalary.isPresent())
			 return null;
		 return optionalSalary.get();
	}
	
	
	public List<Salary> findAllSalary(){
		 return salaryRepository.findAll();
	}
}
