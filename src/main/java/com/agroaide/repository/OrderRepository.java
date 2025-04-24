package com.agroaide.repository;

import com.agroaide.entity.Order;
import com.agroaide.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerId(Long buyerId);
    List<Order> findBySellerId(Long sellerId);
    List<Order> findByStatus(OrderStatus status);
    Optional<Order> findByRazorpayOrderId(String razorpayOrderId);
} 