package com.apro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Payment;
import com.apro.main.repository.PaymentRepo;


@Service
public class PaymentService {
	@Autowired
	private PaymentRepo paymentRepo;
	
	
	public List<Payment> getAllPayments(){
		return paymentRepo.getAllPayments();
	}
	
	public void addPayment(Payment payment) {
		paymentRepo.addPayment(payment);
	}
	
	public Payment getPaymentById(int paymentId) {
		return paymentRepo.getPaymentById(paymentId);
	}
	
	public List<Payment> getPaymentByStatus(String paymentStatus){
		return paymentRepo.getPaymentByStatus(paymentStatus);
	}
	
	public void deletePayment(int paymentId) {
		paymentRepo.deletePayment(paymentId);
	}


}
