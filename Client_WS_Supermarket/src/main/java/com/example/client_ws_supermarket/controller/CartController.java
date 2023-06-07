package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Customer;
import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.OrderDetail;
import com.example.client_ws_supermarket.model.Product;
import com.example.client_ws_supermarket.model.request.OrderProductRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    protected RestTemplate rest = new RestTemplate();


    @GetMapping("")
    public String cartView(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        Order cart = new Order();
        try {
            cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
        }
        catch (Exception e) {
            System.out.println(e);
        }

        session.setAttribute("order", cart);
        return "customer/cart";
    }

    @GetMapping ("addtocart/{productId}")
    public RedirectView addtocart(HttpSession session,
                            @PathVariable Integer productId) {
        Customer customer = (Customer) session.getAttribute("customer");
        //Get Product
        Product product = new Product();
        try {
            product = rest.getForObject("http://localhost:8081/product?id=" + productId ,Product.class);
        }
        catch (Exception e) {
            System.out.println("Chua chay Product Service.");
        }
        //Get Order
        Order cart = new Order();
        try {
            cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
        }
        catch (Exception e) {
            System.out.println("Chu chay Order Service.");
        }
        //Add Product to Cart
        try {
            OrderProductRequest request = new OrderProductRequest(cart, product, null);
            cart = rest.postForObject("http://localhost:8088/api/details/addtocart", request, Order.class );
        }
        catch (Exception e) {
            System.out.println(e);
        }

        session.setAttribute("order", cart);
        return new RedirectView("/cart");
    }

    @GetMapping ("setQuantity/{action}/{productId}")
    public RedirectView setQuantity (HttpSession session,
                                     @PathVariable String action,
                                     @PathVariable Integer productId)
    {
        Customer customer = (Customer) session.getAttribute("customer");
        Product product = rest.getForObject("http://localhost:8081/product?id=" + productId ,Product.class);
        Order order = (Order) session.getAttribute("order");

        try {
            OrderProductRequest request = new OrderProductRequest(order, product, action);
            Order cart = rest.postForObject("http://localhost:8088/api/details/setQuantity", request, Order.class );
            session.setAttribute("order", cart);
        }
        catch (Exception e) {
            System.out.println("Chua thuc hien tang giam");
        }

        return new RedirectView("/cart");
    }

    @GetMapping("checkout")
    public String checkout (Model model) {
        return "customer/checkout";
    }
}
