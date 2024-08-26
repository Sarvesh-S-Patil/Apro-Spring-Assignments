package com.apro.main.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="salaryTransaction")
public class SalaryTransaction {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long transactionId;
	@Column
	LocalDate transactionDate;
	@Column
	double amount;
	@Column
	SalaryStatus status;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="accountNumber")
	@JsonIgnore
	SalaryAccount account;
}
