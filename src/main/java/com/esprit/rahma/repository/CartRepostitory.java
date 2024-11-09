package com.esprit.rahma.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.rahma.model.Cart;
import com.esprit.rahma.model.Product;
import com.esprit.rahma.model.User;

public interface CartRepostitory extends JpaRepository<Cart, Long> {
		public List<Cart> findByUser(User user);

		public Optional<Cart> findByUserAndProduct(User user, Product product);

		
}
