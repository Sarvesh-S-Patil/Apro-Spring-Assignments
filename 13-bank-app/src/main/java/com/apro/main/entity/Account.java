package com.apro.main.entity;

import java.util.ArrayList;
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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	
    @Column(nullable = false)
    @NotBlank(message = "First name is required.")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters.")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name is required.")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters.")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email address is required.")
    @Email(message = "Email address must be valid.")
    private String emailAddress;

    @Column(nullable = false)
    @DecimalMin(value="0.0",message = "Balance must be a non-negative number.")
    private double balance;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "customerId")
	@JsonIgnore
	Customer customer;

	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private List<Transaction> transactions = new ArrayList<>();
	

  
   
	
}
