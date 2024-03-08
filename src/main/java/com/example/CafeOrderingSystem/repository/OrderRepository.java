package com.example.CafeOrderingSystem.repository;

import com.example.CafeOrderingSystem.entity.MenuItem;
import com.example.CafeOrderingSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
    Order save(Order order);
    Optional<Order> findById(int orderId);
    List<Order> findAll();
    void deleteById(int orderId);
}

