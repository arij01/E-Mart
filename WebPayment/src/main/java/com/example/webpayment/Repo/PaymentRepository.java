package com.example.webpayment.Repo;

import com.example.webpayment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
