package com.example.usermicroservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
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
