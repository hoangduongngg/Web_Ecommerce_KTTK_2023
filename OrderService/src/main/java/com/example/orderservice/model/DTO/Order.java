package com.example.orderservice.model.DTO;

import com.example.orderservice.model.entity.OrderEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Order(OrderEntity entity) {
        this.id = entity.getId();
        this.paymentType = entity.getPaymentType();
        this.orderDate = entity.getOrderDate();
        this.paymentDate = entity.getPaymentDate();
        this.cancelDate = entity.getCancelDate();
        this.deliveryDate = entity.getDeliveryDate();
        this.reasonCancel = entity.getReasonCancel();
        this.statusDelivery = entity.getStatusDelivery();
        this.statusOrder = entity.getStatusOrder();
        this.note = entity.getNote();
        this.customer = new Customer(entity.getTblCustomerid());
        this.tblShipperid = entity.getTblShipperid();
        this.details = details(entity.getId());
        this.totalOrder = totalAmount(this.details);
    }
    private List<OrderDetail> details(Integer orderId) {
        List<OrderDetail> details = new ArrayList<>();
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8088/api/details/{orderID}";
        try {
             details = Arrays.asList(rest.getForObject(url, OrderDetail[].class, orderId));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return details;
    }

    private Long totalAmount(List<OrderDetail> details) {
        Long totalAmount = 0L;
        for (OrderDetail od:details) {
            totalAmount += od.getPrice()*od.getQuantity();
        }
        return totalAmount;
    }
}
