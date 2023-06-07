package com.example.client_ws_supermarket.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@Data
@RequiredArgsConstructor
public class OrderDetail {
    private Integer id;
    private Integer quantity;
    private Integer price;
    private Product product;
}
