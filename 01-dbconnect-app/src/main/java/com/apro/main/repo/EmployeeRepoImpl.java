package com.apro.main.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class EmployeeRepoImpl  implements EmployeeRepo{

	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query =entityManager.createQuery("select e from Employee e",Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
	
	
	}

	@Override
	
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub	
		return entityManager.find(Employee.class,employeeId);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name =:theName",Employee.class);
		query.setParameter("theName", name);
		return query.getResultList();
	}

}
