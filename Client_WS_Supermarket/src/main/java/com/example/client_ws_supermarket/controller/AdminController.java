package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Account;
import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.request.StatisticTimeRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    protected RestTemplate rest = new RestTemplate();

    @GetMapping("")
    public String home(HttpSession session, Model model) {
        try {
            Account account = (Account) session.getAttribute("account");
            if (account == null) {
                return "redirect:login";
            }
            if (account.getRole().equalsIgnoreCase("customer")) {
                return "redirect:";
            } else if (account.getRole().equalsIgnoreCase("admin")) {
                return "admin/home";
            } else {
                return "redirect:warehouse";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:login";
        }
    }

    @GetMapping("statisticbytime")
    public String statisticbytime(Model model) {
        List<Order> listO = new ArrayList<>();
        model.addAttribute("listO", listO);
        return "admin/statisticbytime";
    }
    @PostMapping("statisticbytime")
    public String submitForm(
            Model model,
            @RequestParam("optionSelect") String optionSelect,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year
    ) {
        System.out.println("optionSelect: " + optionSelect);
        LocalDate localDate = LocalDate.of(year, month, day);
        StatisticTimeRequest request = new StatisticTimeRequest(localDate, optionSelect);
        List<Order> listO = new ArrayList<>();
        try {
            listO = Arrays.asList(rest.postForObject("http://localhost:8089/api/order/statistic_time", request, Order[].class));
            System.out.println(listO);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Ngày: " + day);
//        System.out.println("Tháng: " + month);
//        System.out.println("Năm: " + year);
        model.addAttribute("optionSelect", optionSelect);
        model.addAttribute("day", day);
        model.addAttribute("month", month);
        model.addAttribute("year", year);

        model.addAttribute("listO", listO);
        return "admin/statisticbytime";
    }

}
