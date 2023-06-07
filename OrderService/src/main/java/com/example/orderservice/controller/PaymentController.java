package com.example.orderservice.controller;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.PayWithPaypalService;
import com.example.orderservice.model.entity.OrderEntity;
//import com.example.orderservice.model.PaymentDetailsEntity;
import com.example.orderservice.repository.OrderRepository;
//import com.example.orderservice.repository.PaymentDetailsRepository;
import com.example.orderservice.service.PayWithPaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paypal.api.payments.Payment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class PaymentController {
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PayWithPaypalService payWithPaypalService;

    @Autowired
    private OrderService orderService;

    // http://localhost:8000/pay
    @PostMapping("/pay")
    public String payment(@RequestParam int orderId) {

        String token = "";
        try {
            OrderEntity orderEntity = orderRepository.findOrderEntityById(orderId);
            Order order = new Order(orderEntity);
            System.out.println("Đã chạy được đến Pay Service: " + order);
            System.out.println(order.getTotalOrder());
//            OrderEntity order = orderRepository.findOrderEntityById(orderId);
            Payment payment = payWithPaypalService.createPayment(
                    (double) (order.getTotalOrder()),
                    "USD",
                    "paypal",
                    "sale",
                    "thanh toan hoa don",
                    "http://localhost:8089/" + PAYPAL_CANCEL_URL,
                    "http://localhost:8089/" + PAYPAL_SUCCESS_URL);
            System.out.println(payment);

//            PaymentDetailsEntity paymentDetails = new PaymentDetailsEntity();
//            paymentDetails.setOrderId(orderId);
//            paymentDetails.setAmount(order.getAmount());
//            paymentDetails.setPaymentStatus("PENDING");

            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    String[] s = link.getHref().split("=");
                    token = s[2];
//                    paymentDetails.setToken(token);
//                    paymentDetailsRepository.save(paymentDetails);

//                    OrderEntity orderEntity = orderRepository.findById(order.getId());
                    orderEntity.setStatusOrder(token);
                    orderRepository.save(orderEntity);
                    return link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "payment pending";
    }

    @GetMapping(value = PAYPAL_CANCEL_URL)
    public String cancelPay(
            @RequestParam("token") String token
    ) {
//        PaymentDetailsEntity paymentDetails = paymentDetailsRepository.getByToken(token);
//        paymentDetails.setPaymentDate(LocalDateTime.now());
//        paymentDetails.setPaymentStatus("PAYMENT CANCELLED");
//        paymentDetailsRepository.save(paymentDetails);

        OrderEntity orderEntity = orderRepository.findByStatusOrder(token);
        orderEntity.setStatusOrder("order");
        orderRepository.save(orderEntity);
        System.out.println("Thanh toan chua thanh cong!");

//        OrderEntity order = orderRepository.findOrderEntityById(paymentDetails.getOrderId());
//        order.setPaymentType("PAYPAL");
//        order.setPaymentStatus("PAYMENT CANCELLED");
//        order.setPaymentDate(Date.from(Instant.now()));
//        orderRepository.save(order);
        return "payment failed";
    }
    @GetMapping(value = PAYPAL_SUCCESS_URL)
    public String successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("token") String token,
            @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payWithPaypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
//                PaymentDetailsEntity paymentDetails = paymentDetailsRepository.getByToken(token);
//                paymentDetails.setPaymentDate(LocalDateTime.now());
//                paymentDetails.setPaymentStatus("PAYMENT SUCCESS");
//                paymentDetailsRepository.save(paymentDetails);

                OrderEntity orderEntity = orderRepository.findByStatusOrder(token);
                orderEntity.setPaymentDate(getCurrentDate());
                orderEntity.setStatusOrder("bill");
                orderEntity.setPaymentType("online");
                orderRepository.save(orderEntity);
                System.out.println("Thanh tooan thanh cong luc:" + orderEntity.getPaymentDate());

//                OrderEntity order = orderRepository.findOrderEntityById(paymentDetails.getOrderId());
//                order.setPaymentType("PAYPAL");
//                order.setPaymentStatus("PAYMENT SUCCESS");
//                order.setPaymentDate(Date.from(Instant.now()));
//                orderRepository.save(order);
                return "payment success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "payment success";
    }

    private Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }

}
