/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerDTO;
import com.example.demo.Repository.CustomerRepository;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static javax.swing.UIManager.get;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ben
 */
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> listCustomer = customerRepository.findAll();
        if (listCustomer.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(listCustomer);
        }
    }

    @GetMapping("/customer")
    @ResponseBody
    public ResponseEntity<Customer> getById(@RequestParam Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/add-customer")
    @ResponseBody
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        System.out.println(customerDTO.phoneNumber);
        Optional<Customer> customer = customerRepository.findByPhoneNumber(customerDTO.phoneNumber);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Customer addCustomer = new Customer(customerDTO);
            customerRepository.save(addCustomer);
            return ResponseEntity.ok(addCustomer);
        }

    }

    @PostMapping("/update-customer")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        Optional<Customer> customer = customerRepository.findById(customerDTO.id);
        if (customer.isPresent()) {
            Customer addCustomer = new Customer(customerDTO);
            customerRepository.save(addCustomer);
            return ResponseEntity.ok(addCustomer);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/update-customer/img")
    @ResponseBody
    public ResponseEntity<String> updateImgCustomer(@RequestParam("img") MultipartFile img,
            @RequestParam Integer id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            try {
                Map<String, String> config = new HashMap<>();
                config.put("cloud_name", "dne2tjjym");
                config.put("api_key", "871314462855254");
                config.put("api_secret", "m_8hFHYWag6pdETWKh4_rhCkBTg");
                Cloudinary cloudinary = new Cloudinary(config);

                String url = (String) cloudinary.uploader().upload(img.getBytes(), ObjectUtils.asMap(
                        "folder", "customers",
                        "public_id", "customer_" + id)).get("url");
                customer.get().setImg(url);
                customerRepository.save(customer.get());
                return ResponseEntity.ok("ok");

            } catch (Exception e) {
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
            }
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/search-customer")
    @ResponseBody
    public ResponseEntity<List<Customer>> searchByKeyword(@RequestParam String keyword) {
        List<Customer> listCustomer = customerRepository.findByNameContainingIgnoreCase(keyword);
        if (listCustomer.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(listCustomer);
        }
    }
    
    @DeleteMapping("/delete-customer")
    @ResponseBody
    public ResponseEntity<?> deleteCustomer(@RequestParam int id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
            return ResponseEntity.ok(customer.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
    }

    @PostMapping("/customer-login")
    @ResponseBody
    public ResponseEntity<?> customerLogin(@RequestBody String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
