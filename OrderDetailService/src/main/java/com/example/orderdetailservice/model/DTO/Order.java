package com.example.orderdetailservice.model.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {
    private Integer id;
    private String paymentType;
    private Date orderDate;
    private Date paymentDate;
    private Date cancelDate;
    private Date deliveryDate;
    private String reasonCancel;
    private String statusDelivery;
    private String statusOrder;
    private String note;
    private Customer customer;
    private Integer tblShipperid;
    private Long totalOrder;
    private List<OrderDetail> details;
}
