package com.example.CafeOrderingSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private double subtotal;
    private double serviceFee;
    private double tax;
    private double tip;
    private double total;

}
