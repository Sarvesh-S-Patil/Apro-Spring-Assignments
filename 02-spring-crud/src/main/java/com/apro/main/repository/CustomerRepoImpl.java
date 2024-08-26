package com.apro.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Customer;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class CustomerRepoImpl  implements CustomerRepo{

	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query =entityManager.createQuery("select c from Customer c",Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public List<Customer> getCustomerByFirstName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.firstName =:theName",Customer.class);
		query.setParameter("theName", name);
		return query.getResultList();
	}
	
	@Override
    @Transactional
    public void deleteCustomer(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

}
