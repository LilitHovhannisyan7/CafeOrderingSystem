package com.example.CafeOrderingSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int waiterId;
    private int tableNumber;
    private LocalDateTime orderTime;
    private boolean finalized;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    // Other properties, constructors, getters, and setters

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
}
