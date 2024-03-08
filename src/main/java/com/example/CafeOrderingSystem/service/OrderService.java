package com.example.CafeOrderingSystem.service;

import com.example.CafeOrderingSystem.entity.Order;
import com.example.CafeOrderingSystem.entity.OrderDetail;
import com.example.CafeOrderingSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void cancelOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order modifyOrder(Order order) {
        return orderRepository.save(order);
    }
}
