package com.apro.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column
	public long adminId;
	
	@Column
	@OneToMany(mappedBy = "admin", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,})
	public List<Customer> customers;
	
	
}
