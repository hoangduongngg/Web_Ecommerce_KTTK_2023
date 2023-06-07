package com.example.orderdetailservice.model.request;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderProductRequest {
    private Order order;
    private Product product;
    private String action;
}
