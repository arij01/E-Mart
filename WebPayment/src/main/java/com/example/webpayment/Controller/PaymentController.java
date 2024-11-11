package com.example.webpayment.Controller;

import com.example.webpayment.Dto.PaymentRequest;
import com.example.webpayment.Entity.Payment;
import com.example.webpayment.Services.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    public ResponseEntity<Integer> createPayment(
            @RequestBody @Valid PaymentRequest request
    ) {
        return ResponseEntity.ok(this.service.createPayment(request));
    }

    @GetMapping()
    public ResponseEntity<List<Payment>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

}
