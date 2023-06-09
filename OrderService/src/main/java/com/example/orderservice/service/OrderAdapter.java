package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Customer;
import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderAdapter {
    public OrderEntity adapter_toEntity (Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId()) ;
        entity.setPaymentType(order.getPaymentType());
        entity.setOrderDate(order.getOrderDate());
        entity.setPaymentDate(order.getPaymentDate());
        entity.setCancelDate(order.getCancelDate());
        entity.setDeliveryDate(order.getDeliveryDate());
        entity.setReasonCancel(order.getReasonCancel());
        entity.setStatusDelivery(order.getStatusDelivery());
        entity.setStatusOrder(order.getStatusOrder());
        entity.setNote(order.getNote());
        entity.setTblCustomerid(order.getCustomer().getId());
        entity.setTblShipperid(order.getTblShipperid());
        return entity;
    }

    public Order adapter_toOrder (OrderEntity entity) {
        Order order = new Order(entity);
        return order;
    }

    public List<Order> adapter_toListOrder(List<OrderEntity> entityList) {
        List<Order> orderList = new ArrayList<>();
        for (OrderEntity entity: entityList) {
            orderList.add(adapter_toOrder(entity));
        }
        return orderList;
    }

}
