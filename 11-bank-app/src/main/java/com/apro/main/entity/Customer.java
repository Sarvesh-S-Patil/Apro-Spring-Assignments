package com.apro.main.entity;

import java.io.Serializable;
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
@Table(name = "customer")
public class Customer implements Serializable {
	@Column
	@Id
	Long customerId;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String email;
	@Column
	String password;
	
	@Column
	@OneToMany(mappedBy = "customer",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	public List<Account> accounts;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name = "adminId")
	@JsonIgnore
	Admin admin;

}
