package com.example.orderservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tblorder")
public class OrderEntity {
    private static final long serialVersionUID = 100000000000002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "cancel_date")
    private Date cancelDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "reason_cancel")
    private String reasonCancel;

    @Column(name = "status_delivery")
    private String statusDelivery;

    @Column(name = "status_order")
    private String statusOrder;

    @Column(name = "note")
    private String note;

    @Column(name = "tbl_customerid")
    private Integer tblCustomerid;
    @Column(name = "tbl_shipperid")
    private Integer tblShipperid;

//    private Float totalAmount;
//    @OneToMany(mappedBy = "tbl_orderdetailid")
//    private List<OrderDetail> details;


}
