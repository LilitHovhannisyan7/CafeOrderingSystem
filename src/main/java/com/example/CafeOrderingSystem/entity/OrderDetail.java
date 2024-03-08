package com.example.CafeOrderingSystem.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;

    private int orderId;
    private int itemId;
    private int quantity;
    private double priceAtTime;
}