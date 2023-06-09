package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderAdapter adapter;

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
    public Order back_to_cart (Order order) {
        try {
            OrderEntity orderEntity = orderRepository.findOrderEntityById(order.getId());
            orderEntity.setStatusOrder("cart");
            orderEntity.setOrderDate(null);
            orderRepository.save(orderEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
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

    @Override
    public List<Order> statistic_by_time(LocalDate localDate, String optionSelect) {
        List<OrderEntity> entityList = new ArrayList<>();
        switch (optionSelect) {
            case "year":
                entityList = findAllByEventDateYear(localDate.getYear());
                return adapter.adapter_toListOrder(entityList);
//            case "month":
//                entityList = orderRepository.findByPaymentDateYearAndPaymentDateMonth(localDate.getYear(), localDate.getMonthValue());
            case "day":
                Date date = java.sql.Date.valueOf(localDate);
                System.out.println("OrderService: " + date);
                entityList = orderRepository.findByPaymentDate(date);
        }

        return adapter.adapter_toListOrder(entityList);
    }

    public List<OrderEntity> findAllByEventDateYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        Date dateStart = cal.getTime();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 11); // 11 = december
        cal.set(Calendar.DAY_OF_MONTH, 31);
        Date dateEnd = cal.getTime();

        List<OrderEntity> listO = orderRepository.findByPaymentDateBetween(dateStart, dateEnd);
        return listO;
    }

    private Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }


}
