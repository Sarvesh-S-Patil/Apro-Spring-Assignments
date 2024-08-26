package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.SalaryAccount;

public interface SalaryAccountRepository extends JpaRepository<SalaryAccount,Long> {

}
