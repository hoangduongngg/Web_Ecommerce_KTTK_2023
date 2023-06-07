package com.example.orderdetailservice.model.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tblorderdetail")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Integer price;
    private Integer tblProductid;
    private Integer tblOrderid;
}
