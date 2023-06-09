package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Order;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("payment")
public class PaymentController {
    protected RestTemplate rest = new RestTemplate();
    @GetMapping("")
    public RedirectView payment_Paypal(HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        try {
            String pay_link = rest.getForObject("http://localhost:8089/pay/" + order.getId(), String.class);
            if (pay_link != null) {
                System.out.println(pay_link);
                return new RedirectView(pay_link);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("");

    }

    @GetMapping ("success")
    public String success() {
        return "customer/payment/success";
    }

}
