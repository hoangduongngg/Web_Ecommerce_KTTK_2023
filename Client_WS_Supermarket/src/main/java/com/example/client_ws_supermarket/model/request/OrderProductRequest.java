package com.example.client_ws_supermarket.model.request;

import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.Product;
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
