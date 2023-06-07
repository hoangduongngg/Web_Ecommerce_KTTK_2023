/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ben
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Optional<Customer> findById(Integer id);

    List<Customer> findByNameContainingIgnoreCase(String keyword);

    Optional<Customer> findByEmail(String email);
    
}
