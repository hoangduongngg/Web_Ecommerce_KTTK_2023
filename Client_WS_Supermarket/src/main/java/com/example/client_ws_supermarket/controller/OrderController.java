package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.OrderDetail;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("order")

public class OrderController {
    protected RestTemplate rest = new RestTemplate();
    @GetMapping("checkout")
    public String checkout(HttpSession session, Model model) {
        Order order = (Order) session.getAttribute("order");
        if (order.getStatusOrder().equalsIgnoreCase("cart")) {
            order = rest.postForObject("http://localhost:8089/api/order/checkout",order, Order.class);
            session.setAttribute("order", order);
            System.out.println("Checkout: " + order.getStatusOrder());
        }

        List<OrderDetail> list_od = order.getDetails();
        model.addAttribute("list_od", list_od);
        model.addAttribute("order", order);

        return "customer/checkout";
    }

    @GetMapping("waitingforpayment")
    public String waitingforpayment(HttpSession session, Model model) {
        Order order = (Order) session.getAttribute("order");
        if (order.getStatusOrder().equalsIgnoreCase("order")) {
            order = rest.postForObject("http://localhost:8089/api/order/waitingforpayment",order, Order.class);
            session.setAttribute("order", order);
            System.out.println("Checkout: " + order.getStatusOrder());
        }

        List<OrderDetail> list_od = order.getDetails();
        model.addAttribute("list_od", list_od);
        model.addAttribute("order", order);

        return "customer/waitingforpayment";
    }

    @GetMapping("pay")
    public String payment_Paypal(HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        System.out.println("Đã chạy được đến Pay Client");
        try {
            String pay_link = rest.getForObject("http://localhost:8089/pay?orderId=" + order.getId(), String.class);
            if (pay_link == null) {
                System.out.println("pay_link return null");
            }
            return pay_link;
        }
        catch (Exception e) {
            System.out.println("");
            return "customer/waitingforpayment";
        }

    }
}
