package com.apro.main.config;

import org.springframework.batch.item.ItemProcessor;

import org.springframework.stereotype.Component;

import com.apro.main.config.entity.Employee;


@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}
	
}
