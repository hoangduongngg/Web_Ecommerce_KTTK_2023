/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;

import com.example.demo.Model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ben
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByNameContains(String keyword);

    @Query("SELECT p FROM Product p WHERE p.name = :name AND p.idSupplier = :idSupplier")
    Optional<Product> findByNameAndIdSupplied(String name, int idSupplier);
    
    List<Product> findByNameContainingIgnoreCase(String keyword);

    List<Product> findByNameContainingIgnoreCaseAndPriceLessThan(String keyword, Integer maxPrice);
    
    List<Product> findByNameContainingIgnoreCaseAndPriceGreaterThan(String keyword, Integer minPrice);
    
    List<Product> findByNameContainingIgnoreCaseAndPriceBetween(String keyword, Integer minPrice, Integer maxPrice);

    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);

    List<Product> findByPriceGreaterThan(Integer minPrice);

    Optional<Product> findByName(String name);
    
}
