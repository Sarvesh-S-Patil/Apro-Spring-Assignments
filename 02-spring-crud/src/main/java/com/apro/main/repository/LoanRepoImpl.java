package com.apro.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Loan;
import com.apro.main.entity.LoanStatus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class LoanRepoImpl implements LoanRepo {
	@Autowired
	private EntityManager entityManager;
	
	public List<Loan> getAllLoans(){
		TypedQuery<Loan> query =entityManager.createQuery("select l from Loan l",Loan.class);
		return query.getResultList();
	}
	
	@Transactional
	public void addLoan(Loan loan) {
		
		entityManager.persist(loan);
	}
	
	public Loan getLoanById(int loanId) {
		return entityManager.find(Loan.class, loanId);
		
	}
	
	public List<Loan> getLoanByStatus(String loanStatus){
		TypedQuery<Loan> query = entityManager.createQuery("select l from Loan l where l.loanStatus =:theLoanStatus",Loan.class);
		query.setParameter("theLoanStatus", loanStatus);
		return query.getResultList();
	}
	
	@Transactional
	public void deleteLoan(int loanId) {
		Loan loan = entityManager.find(Loan.class,loanId);
        if (loan != null) {
            entityManager.remove(loan);
        }
	}

}
