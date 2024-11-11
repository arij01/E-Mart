package com.example.webpayment.Dto;

import com.example.webpayment.Entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(Integer id,
                             BigDecimal amount,
                             PaymentMethod paymentMethod,
                             Integer orderId,
                             String orderReference,
                             Customer customer) {
}
