package tn.esprit.ecommerce.kafka;

import tn.esprit.ecommerce.customer.CustomerResponse;
import tn.esprit.ecommerce.order.PaymentMethod;
import tn.esprit.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
