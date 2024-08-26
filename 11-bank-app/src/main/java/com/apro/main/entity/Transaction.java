package com.apro.main.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private long transactionId;
	@Column
    private long senderAccountId;
	@Column
    private long recieverAccountId;
	@Column
    private String transactionType;
	@Column
    private double amount;
	@Column 
    private String date; 
   
}
