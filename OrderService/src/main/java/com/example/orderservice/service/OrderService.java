package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OrderService {
    Order getCartByCustomerId (Integer id);
    Order checkout(Order order);
    Order back_to_cart (Order order);
    Order waitingforpayment(Order order);

    List<Order> statistic_by_time (LocalDate date, String optionSelect);
}
