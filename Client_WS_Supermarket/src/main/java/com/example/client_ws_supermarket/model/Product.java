package com.example.client_ws_supermarket.model;

import lombok.Data;
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

}
