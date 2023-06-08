package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("")
    public String home(HttpSession session, Model model) {
        try {
            Account account = (Account) session.getAttribute("account");
            if (account== null) {
                return "redirect:login";
            }
            if (account.getRole().equalsIgnoreCase("customer")) {
                return "redirect:";
            }
            else if(account.getRole().equalsIgnoreCase("admin")){
                return "admin/home";
            }else{
                return "redirect:warehouse";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:login";
        }
    }
}
