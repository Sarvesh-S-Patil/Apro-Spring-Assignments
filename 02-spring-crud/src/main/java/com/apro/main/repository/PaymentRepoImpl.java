package com.apro.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class PaymentRepoImpl  implements PaymentRepo{

    
    @Autowired
    private EntityManager entityManager;
	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
	
	}
	@Transactional
	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		entityManager.persist(payment);
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return entityManager.find(Payment.class, paymentId);
	}

	@Override
	public List<Payment> getPaymentByStatus(String paymentStatus) {
		// TODO Auto-generated method stub
		TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.paymentStatus = :thePaymentStatus", Payment.class);
        query.setParameter("thePaymentStatus", paymentStatus);
        return query.getResultList();
	}
	@Transactional
	@Override
	public void deletePayment(int paymentId) {
		// TODO Auto-generated method stub
		Payment payment = entityManager.find(Payment.class, paymentId);
        if (payment != null) {
            entityManager.remove(payment);
        }
		
	}

}
