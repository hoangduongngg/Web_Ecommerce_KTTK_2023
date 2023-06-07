/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByImg", query = "SELECT p FROM Product p WHERE p.img = :img"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByquantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByExpirationDate", query = "SELECT p FROM Product p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "Product.findByIdSupplier", query = "SELECT p FROM Product p WHERE p.idSupplier = :idSupplier")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "expiration_date")
    private String expirationDate;
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, String img, int price, int quantity, String expirationDate, int idSupplier) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.idSupplier = idSupplier;
    }

    public Product(ProductRequest productRequest) {
        this.name = productRequest.name;
        this.img = productRequest.img;
        this.price = productRequest.price;
        this.quantity = productRequest.quantity;
        this.expirationDate = productRequest.expirationDate;
        this.description = productRequest.description;
        this.idSupplier = productRequest.idSupplier;
    }

    public Product(String name, String url, int price, int quantity, String expirationDate, String description) {
        this.name = name;
        this.img = url;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public String toString() {
        return "com.example.demo.Model.Product[ id=" + id + " ]";
    }

}
