package com.example.payment_service.controller;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.entity.PaymentStatus;
import com.example.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment createPayment(
            @RequestBody Payment payment) {

        return paymentService.createPayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(
            @PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(
            @PathVariable Long id,
            @RequestBody Payment payment) {

        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public Payment deletePayment(
            @PathVariable Long id) {

        return paymentService.deletePayment(id);
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getPaymentsByBooking(
            @PathVariable Long bookingId) {

        return paymentService
                .getPaymentsByBooking(bookingId);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUser(
            @PathVariable Long userId) {

        return paymentService
                .getPaymentsByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(
            @PathVariable PaymentStatus status) {

        return paymentService
                .getPaymentsByStatus(status);
    }

    @GetMapping("/transaction/{transactionId}")
    public Payment getPaymentByTransactionId(
            @PathVariable String transactionId) {

        return paymentService
                .getPaymentByTransactionId(transactionId);
    }

    @PutMapping("/{id}/process")
    public Payment processPayment(
            @PathVariable Long id) {

        return paymentService.processPayment(id);
    }

    @PutMapping("/{id}/refund")
    public Payment refundPayment(
            @PathVariable Long id) {

        return paymentService.refundPayment(id);
    }
}