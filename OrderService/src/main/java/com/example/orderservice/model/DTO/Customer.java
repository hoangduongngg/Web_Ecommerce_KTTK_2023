package com.example.orderservice.model.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Customer {
    private Integer id;

    public Customer(Integer id) {
        this.id = id;
    }
}
