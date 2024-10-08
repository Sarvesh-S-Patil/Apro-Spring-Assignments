package com.apro.main.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="client")

public class Client  implements Comparable<Client>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int clientId;
	
	@Column
	@NotBlank(message = "company name cannot be empty")
	String companyName;
	@Column
	@NotNull(message = "registration number cannot be empty")
	@Min(value = 1, message = "Registration number must be a positive number")
	int registrationNumber;
	@Column
	@NotBlank(message = "contact person canot be empty")
	String contactPerson;
	@Column
	@Email(message = "email address is not valid")
	String contactEmail;
	@Column
	@NotNull(message = "contact number cannot be empty")
	int contactNumber;
	@Column
	@NotBlank(message = "address cannot be empty")
	String address;
	@Column
	@Enumerated(EnumType.STRING)
	ClientStatus clientStatus;
	@Column
	LocalDate creationDate;
	@Column
	@Enumerated(EnumType.STRING)
	KycStatus kycStatus;
	
	@Override
	public int compareTo(Client other) {
	     return this.clientId-other.clientId;
	}
}
