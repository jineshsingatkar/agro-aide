package com.agroaide.service;

import com.agroaide.entity.Order;
import com.agroaide.entity.OrderStatus;
import com.agroaide.repository.OrderRepository;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public String createRazorpayOrder(Order order) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject options = new JSONObject();
        options.put("amount", order.getTotalAmount().multiply(new BigDecimal("100")).longValue());
        options.put("currency", "INR");
        options.put("receipt", "order_" + order.getId());
        
        com.razorpay.Order razorpayOrder = razorpay.orders.create(options);
        order.setRazorpayOrderId(razorpayOrder.get("id"));
        orderRepository.save(order);
        
        return razorpayOrder.get("id");
    }

    public boolean verifyPayment(String orderId, String paymentId, String signature) {
        try {
            RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
            JSONObject attributes = new JSONObject();
            attributes.put("razorpay_order_id", orderId);
            attributes.put("razorpay_payment_id", paymentId);
            attributes.put("razorpay_signature", signature);
            
            boolean isValid = razorpay.utility.verifyPaymentSignature(attributes);
            if (isValid) {
                Order order = orderRepository.findByRazorpayOrderId(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found"));
                order.setRazorpayPaymentId(paymentId);
                order.setRazorpaySignature(signature);
                order.setStatus(OrderStatus.CONFIRMED);
                orderRepository.save(order);
            }
            return isValid;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Order> getOrdersByBuyer(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }

    public List<Order> getOrdersBySeller(Long sellerId) {
        return orderRepository.findBySellerId(sellerId);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
} 