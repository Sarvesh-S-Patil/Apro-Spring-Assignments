package com.apro.main.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Client;
import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
	
	Page<Client> findByCompanyName(String companyName,Pageable pageable);
}
