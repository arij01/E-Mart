package com.example.usermicroservice.Repository;

import com.example.usermicroservice.Entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
