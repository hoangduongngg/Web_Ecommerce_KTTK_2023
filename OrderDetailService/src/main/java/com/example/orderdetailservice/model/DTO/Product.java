package com.example.orderdetailservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

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
