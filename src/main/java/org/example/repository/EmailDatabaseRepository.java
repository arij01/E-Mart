package org.example.repository;

import org.example.entity.EmailDetails;
import org.example.entity.EmailStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping
public interface EmailDatabaseRepository extends JpaRepository<EmailDetails,Integer> {
    List<EmailDetails> findByTriesLessThanAndStatus(int tries, EmailStatus status);
}
