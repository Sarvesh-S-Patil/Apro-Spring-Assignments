package com.apro.main.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client")
public class Client {
	@Id
	@Column
	long clientId;
	@Column
	String companyName;
	@Column
	long registrationNumber;
	@Column
	String contactPerson;
	@Column
	String contactEmail;
	@Column
	long contactNumber;
	@Column
	String address;
	@Column
	@Enumerated(EnumType.STRING)
	ClientStatus status;
	@Column
	LocalDate creationDate;
	@Column
	@Enumerated(EnumType.STRING)
	KycStatus kycStatus;
	@OneToMany(mappedBy = "client",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	List<Employee> employees;
}
