package com.example.orderservice.controller;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")

public class CartController {
    @Autowired
    private OrderService orderService;

    //Get Cart -> Load trang Gio hang
    @GetMapping("/{customerID}")
    public ResponseEntity<Order> cartView (@PathVariable Integer customerID) {
        Order cart = orderService.getCartByCustomerId(customerID);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
    }

}
