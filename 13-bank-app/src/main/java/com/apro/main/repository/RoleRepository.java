package com.apro.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apro.main.entity.Role;


public interface RoleRepository extends JpaRepository<Role,Integer> {
	Optional<Role> findByName(String name);
}
