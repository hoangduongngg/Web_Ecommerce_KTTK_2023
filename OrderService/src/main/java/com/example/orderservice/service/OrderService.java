package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order getCartByCustomerId (Integer id);
    Order checkout(Order order);
    Order waitingforpayment(Order order);
}
