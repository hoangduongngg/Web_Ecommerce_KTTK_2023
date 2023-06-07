package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
@Component
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getCartByCustomerId (Integer id) {
        Optional<OrderEntity> order_entity = orderRepository.findByTblCustomeridAndStatusOrder(id, "cart");
        if (order_entity.isPresent()) { //Da co gio hang
            Order order = new Order(order_entity.get());
            return order;
        }
        else {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setStatusOrder("cart");
            orderEntity.setTblCustomerid(id);
            orderRepository.save(orderEntity);
            return new Order(orderEntity);
        }

    }

    @Override
    public Order checkout(Order order) {
        try {
            OrderEntity orderEntity = orderRepository.findOrderEntityById(order.getId());
            orderEntity.setOrderDate(getCurrentDate());
            orderEntity.setStatusOrder("order");
            orderRepository.save(orderEntity);
            System.out.println("Order Servcie: Order thanh cong luc: " + orderEntity.getStatusOrder());
        }
        catch (Exception e) {
            System.out.println("Order Servcie: Chua them duoc ngay Order Date.");
        }

        return order;
    }

    @Override
    public Order waitingforpayment(Order order) {
        //Chuyen sang trang thanh toan
        try {
            OrderEntity orderEntity = orderRepository.findOrderEntityById(order.getId());
            orderEntity.setStatusOrder("waitingforpayment");
            orderRepository.save(orderEntity);
            System.out.println("Order Servcie: Waiting for payment thanh cong luc: " + orderEntity.getStatusOrder());
        }
        catch (Exception e) {
            System.out.println("Order Servcie: Chua them duoc ngay Order Date.");
        }
        return order;
    }

    private Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }


}
