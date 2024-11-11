package com.example.webpayment.Services;

import com.example.webpayment.Dto.PaymentRequest;
import com.example.webpayment.Entity.Payment;
import com.example.webpayment.NotificationProducer.NotificationProducer;
import com.example.webpayment.NotificationProducer.PaymentNotificationRequest;
import com.example.webpayment.Repo.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.mapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }

    public List<Payment> getAllCustomers() {
        return repository.findAll();
    }


}

