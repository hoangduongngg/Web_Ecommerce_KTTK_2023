package com.example.orderservice.controller;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.PaypalService;
//import com.example.orderservice.model.PaymentDetailsEntity;
//import com.example.orderservice.repository.PaymentDetailsRepository;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class PaymentRestController {
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private OrderService orderService;

    // http://localhost:8089/pay
    @GetMapping("/pay/{orderId}")
    public String payment(@PathVariable int orderId) {

        String token = "";
        try {
            OrderEntity orderEntity = orderRepository.findOrderEntityById(orderId);
            Order order = new Order(orderEntity);
            System.out.println("Đã chạy được đến Pay Service: " + order);
            System.out.println((double) order.getTotalOrder());
            Double total = Double.valueOf(order.getTotalOrder());
            Payment payment = paypalService.createPayment(
                    total,
                    "USD",
                    "paypal",
                    "sale",
                    "thanh toan hoa don",
                    "http://localhost:8089/" + PAYPAL_CANCEL_URL,
                    "http://localhost:8089/" + PAYPAL_SUCCESS_URL);
            System.out.println(payment);

            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    String[] s = link.getHref().split("=");
                    token = s[2];

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
        OrderEntity orderEntity = orderRepository.findByStatusOrder(token);
        orderEntity.setStatusOrder("order");
        orderRepository.save(orderEntity);
        System.out.println("Thanh toan chua thanh cong!");
        return "payment failed";
    }
    @GetMapping(value = PAYPAL_SUCCESS_URL)
    public RedirectView successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("token") String token,
            @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                OrderEntity orderEntity = orderRepository.findByStatusOrder(token);
                orderEntity.setPaymentDate(getCurrentDate());
                orderEntity.setStatusOrder("bill");
                orderEntity.setPaymentType("online");
                orderRepository.save(orderEntity);
                System.out.println("Thanh tooan thanh cong luc:" + orderEntity.getPaymentDate());

//                return "payment success";
//                return new ResponseEntity<>("payment/success", HttpStatus.OK);
                return new RedirectView("http://localhost:8000/payment/success");
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
//        return new ResponseEntity<>("payment/success", HttpStatus.OK);
        return new RedirectView("http://localhost:8000/payment/success");

    }

    private Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }


}
