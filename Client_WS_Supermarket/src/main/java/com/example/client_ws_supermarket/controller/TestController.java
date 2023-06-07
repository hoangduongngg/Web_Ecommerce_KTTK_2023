package com.example.client_ws_supermarket.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("")
public class TestController {

    protected RestTemplate rest = new RestTemplate();

    @GetMapping("/update")
    public String test_home() {
        return "admin/updateProduct";
    }

    
   
    
}
