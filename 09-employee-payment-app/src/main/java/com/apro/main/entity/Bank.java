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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {
	@Id
	@Column
	long bankId;
	@Column
	String bankName;
	@Column
	long ifscNumber;
	@OneToMany(mappedBy = "bank",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	List<SalaryAccount> accounts;
}
