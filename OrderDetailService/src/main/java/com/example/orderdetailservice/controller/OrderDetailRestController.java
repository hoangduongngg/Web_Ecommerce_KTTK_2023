package com.example.orderdetailservice.controller;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.OrderDetail;
import com.example.orderdetailservice.model.DTO.Product;
import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import com.example.orderdetailservice.model.request.OrderProductRequest;
import com.example.orderdetailservice.repository.OrderDetailRepository;
import com.example.orderdetailservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/details", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")

public class OrderDetailRestController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailService orderDetailService;

//    @GetMapping("/{orderID}")
//    public ResponseEntity<List<OrderDetailEntity>> listOrderDetail (@PathVariable Integer orderID) {
//        List <OrderDetailEntity> list_od = orderDetailRepository.findByTblOrderid(orderID);
//        if (list_od == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).body(list_od);
//        }
//    }

    @GetMapping("/{orderID}")
    public ResponseEntity<List<OrderDetail>> getListDetails (@PathVariable Integer orderID) {
        List<OrderDetail> list_od = orderDetailService.getListDetailsByOrder(orderID);
        if (list_od == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list_od);
        }
    }

    //    localhost:8088/api/details/addtocart?productId=1&orderId=29
    @PostMapping(value = "/addtocart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addtoCart (@RequestBody OrderProductRequest request) {
        Order order = request.getOrder();
        Product product = request.getProduct();
        System.out.println("Da gui duoc order:" + order.getStatusOrder());
        System.out.println("Da gui duoc product:" + product.getName());

        Order cart = orderDetailService.addtoCart(product, order);

        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            System.out.println(cart.getDetails());
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
    }

    @PostMapping(value = "/setQuantity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> SetQuantityProductInCart (
            @RequestBody OrderProductRequest request) {
        Order order = request.getOrder();
        Product product = request.getProduct();
        String action = request.getAction();
        System.out.println("Da gui duoc order:" + order.getStatusOrder());
        System.out.println("Da gui duoc product:" + product.getName());
        System.out.println("Da gui duoc action:" + action);


        Order cart = orderDetailService.setQuantityProductInCart(product, order, action);
        System.out.println(cart);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            System.out.println(cart.getDetails());
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
    }
}
