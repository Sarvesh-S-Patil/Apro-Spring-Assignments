package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.apro.main.entity.SalaryTransaction;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Long> {

}
