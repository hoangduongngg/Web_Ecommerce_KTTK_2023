package com.example.orderservice.controller;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/checkout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> checkout (@RequestBody Order order) {
        //Neu la Cart thi set thanh Order
        if (order.getStatusOrder().equalsIgnoreCase("cart")) {
            order = orderService.checkout(order);
        }
        else {
            //neu vao thang trang checkout, da co order
            System.out.println("Khong co order");
        }

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
    }

    @PostMapping(value = "/waitingforpayment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> waitingforpayment (@RequestBody Order order) {
        //Neu la Cart thi set thanh Order
        if (order.getStatusOrder().equalsIgnoreCase("order")) {
            order = orderService.waitingforpayment(order);
        }
        else {
            //neu vao thang trang checkout, da co order
            System.out.println("Khong co order");
        }

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
    }
}
