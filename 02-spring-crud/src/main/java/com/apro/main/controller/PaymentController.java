package com.apro.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.entity.Payment;
import com.apro.main.service.PaymentService;

@RestController
@RequestMapping("/payment-app")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping("/payments")
    public String addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return "Payment added successfully";
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @GetMapping("/payments/status")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(@RequestParam String status) {
        return ResponseEntity.ok(paymentService.getPaymentByStatus(status));
    }

    @DeleteMapping("/payments/{paymentId}")
    public String deletePayment(@PathVariable int paymentId) {
        paymentService.deletePayment(paymentId);
        return "Payment deleted successfully";
    }
}

