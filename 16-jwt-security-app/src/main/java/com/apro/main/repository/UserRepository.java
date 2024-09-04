package com.apro.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByUserName(String userName);
	boolean existsByUserName(String userName);
}
