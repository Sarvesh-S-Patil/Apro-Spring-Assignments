package com.apro.main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Column
	@Id
	long accountId;
	
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String emailAddress;
	@Column
	double balance;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "customerId")
	@JsonIgnore
	Customer customer;
	
	@OneToMany(mappedBy = "account",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	List<Transaction> transactions;
	
}
