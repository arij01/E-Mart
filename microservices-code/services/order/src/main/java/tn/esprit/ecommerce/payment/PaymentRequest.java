package tn.esprit.ecommerce.payment;

import tn.esprit.ecommerce.customer.CustomerResponse;
import tn.esprit.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
