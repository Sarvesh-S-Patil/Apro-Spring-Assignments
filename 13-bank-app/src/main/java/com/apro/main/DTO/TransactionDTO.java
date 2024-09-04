package com.apro.main.DTO;




import com.apro.main.entity.Transaction;
import com.apro.main.entity.TransactionType;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO {
    private long transactionId;

    @NotNull(message = "Sender account ID cannot be null")
    @DecimalMin(value = "0", message = "Sender account ID must be a positive number")
    private long senderAccountId;

    @NotNull(message = "Receiver account ID cannot be null")
    @DecimalMin(value = "0", message = "Receiver account ID must be a positive number")
    private long recieverAccountId;

    @NotNull(message = "Transaction type cannot be null")
    private TransactionType transactionType;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private double amount;

 
    private String date;
    
    private boolean TransactionStatus=true;
    
    
    public static TransactionDTO toTransactionDTOMapper(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transaction.getTransactionId());
        transactionDTO.setSenderAccountId(transaction.getSenderAccountId());
        transactionDTO.setRecieverAccountId(transaction.getRecieverAccountId());
        transactionDTO.setTransactionType(transaction.getTransactionType());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDate(transaction.getDate());

        return transactionDTO;
    }
    
    
    public static Transaction toTransactionMapper(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionDTO.getTransactionId());
        transaction.setSenderAccountId(transactionDTO.getSenderAccountId());
        transaction.setRecieverAccountId(transactionDTO.getRecieverAccountId());
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getDate());

        return transaction;
    }

    
}
