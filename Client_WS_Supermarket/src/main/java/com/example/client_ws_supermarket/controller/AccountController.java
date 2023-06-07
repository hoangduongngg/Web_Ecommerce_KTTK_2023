/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Account;
import com.example.client_ws_supermarket.model.Account;
import com.example.client_ws_supermarket.model.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ben
 */
@CrossOrigin
@Controller
@RequestMapping("")
public class AccountController {

    protected RestTemplate rest = new RestTemplate();

    @GetMapping("login")
    public String login(HttpSession session) {
        return "account/login";
    }

    @PostMapping("login")
    public String doLogin(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {

        String url = "http://localhost:8080/login?username=" + username + "&password=" + password;
        ResponseEntity<Account> responseEntity;
        try {
            responseEntity = rest.getForEntity(url, Account.class);
            session.setAttribute("account", responseEntity.getBody());
            System.out.println(responseEntity.getBody());
            return "redirect:./";
        } catch (Exception e) {
            return "account/login";
        }

    }

    @GetMapping("register")
    public String register() {
        return "account/register";
    }
}
