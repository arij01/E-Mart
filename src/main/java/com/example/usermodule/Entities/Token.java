package com.example.usermodule.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Token {
    @Id
    @GeneratedValue
    private Integer id ;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime   expiresAt;
    private LocalDateTime validatedAt;
    @ManyToOne
    private User user;
}
