package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
