/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

/**
 *
 * @author ben
 */
public class ProductRequest {
    public String name;
    public int price;
    public String img;
    public String expirationDate;
    public String description;
    public int quantity;
    public int idSupplier;

    public ProductRequest(String name, int price, String img, String expirationDate, String description, int quantity, int idSupplier) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.expirationDate = expirationDate;
        this.description = description;
        this.quantity = quantity;
        this.idSupplier = idSupplier;
    }
    
}
