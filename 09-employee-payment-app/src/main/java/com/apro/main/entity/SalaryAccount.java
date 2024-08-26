package com.apro.main.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salaryAccount")
public class SalaryAccount {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	long acccountNumber;
	
	@Column
	String accountHolderName;
	
	@OneToMany(mappedBy = "account",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	List<SalaryTransaction>  transactions;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "bankId")
	@JsonIgnore
	Bank bank;

}
