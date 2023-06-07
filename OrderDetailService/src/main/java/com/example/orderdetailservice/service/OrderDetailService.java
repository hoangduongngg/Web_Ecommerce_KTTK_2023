package com.example.orderdetailservice.service;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.OrderDetail;
import com.example.orderdetailservice.model.DTO.Product;
import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    Order addtoCart (Product product, Order cart);
    Order setQuantityProductInCart (Product product, Order cart, String action);

    List<OrderDetail> getListDetailsByOrder (Integer orderId);
}
