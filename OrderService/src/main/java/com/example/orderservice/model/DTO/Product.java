package com.example.orderservice.model.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Product {
    private Integer id;
    private String name;
    private String img;
    private Integer price;
    private int quantity;
    private String description;
    private String expirationDate;
    private int idSupplier;


    public Product(Integer id) {
        this.id = id;
    }
}
