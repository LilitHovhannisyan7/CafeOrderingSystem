package com.example.CafeOrderingSystem.service;

import com.example.CafeOrderingSystem.entity.Bill;
import com.example.CafeOrderingSystem.entity.Order;
import com.example.CafeOrderingSystem.entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public Bill generateBill(Order order) {

        double subtotal = calculateSubtotal(order);
        double serviceFee = subtotal * 0.10;
        double tax = subtotal * 0.20;
        double tip = subtotal * 0.10;
        double total = subtotal + serviceFee + tax + tip;

        Bill bill = new Bill();
        bill.setOrder(order);
        bill.setSubtotal(subtotal);
        bill.setServiceFee(serviceFee);
        bill.setTax(tax);
        bill.setTip(tip);
        bill.setTotal(total);

        return bill;
    }

    private double calculateSubtotal(Order order) {

        double subtotal = 0.0;
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            subtotal += orderDetail.getPriceAtTime() * orderDetail.getQuantity();
        }
        return subtotal;
    }
}

