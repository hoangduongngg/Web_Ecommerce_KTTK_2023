package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    protected RestTemplate rest = new RestTemplate();

    @GetMapping("{id}")
    public String cartView(Model model, @PathVariable Integer id) {
        Product p = new Product();

        String url = "http://localhost:8081/product?id=" + id;
        try {
            p = rest.getForObject(url,Product.class);
        }
        catch (Exception e) {
            System.out.println(e);
            p.setId(id);
            p.setName("Nike 1 '071");
            p.setImg("https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png");
            p.setPrice(100);
            p.setDescription("The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.");
        }


        model.addAttribute("p", p);
        return "customer/product";
    }
    
    @GetMapping("listProduct")
    public String listProduct(Model model){
        String url = "http://localhost:8081/products";
        List<Product> listP = new ArrayList<>();
        try {
            listP = Arrays.asList(rest.getForObject(url,Product[].class));
        }
        catch (Exception e) {
            System.err.println(e);
        }
        model.addAttribute("listP", listP);
        return "admin/listProduct";
    }
    
    @GetMapping("add-product")
    public String viewAddProduct(){
        return "admin/addProduct";
    }
    
    @GetMapping("updateProduct/{id}")
    public String updateProduct(Model model,@PathVariable int id){
        Product p = new Product();

        String url = "http://localhost:8081/product?id=" + id;
        try {
            p = rest.getForObject(url,Product.class);
        }
        catch(Exception e){
            System.err.println(e);
        }
        model.addAttribute("p", p);
        return "admin/updateProduct";
    }
    
    @GetMapping("deleteProduct/{id}")
    public String deletProduct(Model model,@PathVariable int id){
        
        String url = "http://localhost:8081/delete-product?id=" + id;
        ResponseEntity<Void> response = rest.exchange(url, HttpMethod.DELETE, null, Void.class);
        return "redirect:../listProduct";
    }
    
    
}

