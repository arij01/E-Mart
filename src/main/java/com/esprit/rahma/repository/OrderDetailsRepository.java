package com.esprit.rahma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.rahma.model.OrderDetails;
import com.esprit.rahma.model.User;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	public List<OrderDetails> findByUser(User user);

    List<OrderDetails> findByOrderStatus(String orderStatus);

}
