package com.apro.main.repository;

import java.util.List;

import com.apro.main.entity.Loan;
import com.apro.main.entity.Payment;

public interface PaymentRepo {
	
	public List<Payment> getAllPayments();
	
	public void addPayment(Payment payment);
	
	public Payment getPaymentById(int paymentId);
	
	public List<Payment> getPaymentByStatus(String paymentStatus);
	
	public void deletePayment(int paymentId);

}
