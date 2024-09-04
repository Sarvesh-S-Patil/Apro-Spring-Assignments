package com.apro.main.entity;



import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
	@Column
    private long senderAccountId;
	@Column
    private long recieverAccountId;
	@Column
    private TransactionType transactionType;
	@Column
    private double amount;
	@CreationTimestamp
	@Column 
    private String date;
   
}
