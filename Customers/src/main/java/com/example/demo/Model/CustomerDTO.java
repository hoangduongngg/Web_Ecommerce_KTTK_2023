/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.util.Date;

/**
 *
 * @author ben
 */
public class CustomerDTO {

    public Integer id;
    public String name;
    public String address;
    public String email;
    public String phoneNumber;
    public String img;
    public String birthday;

    public CustomerDTO(Integer id, String name, String address, String email, String phoneNumber, String img, String birthday) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.birthday = birthday;
    }

}
