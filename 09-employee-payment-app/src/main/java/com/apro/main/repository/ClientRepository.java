package com.apro.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
