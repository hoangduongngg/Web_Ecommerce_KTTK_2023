/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.Model.Account;
import com.example.demo.Model.AccountDTO;
import com.example.demo.Repository.AccountRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ben
 */
@CrossOrigin
@RestController("/")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    
    @GetMapping("/account")
    @ResponseBody
    public Account getAccount(@RequestParam int id){
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }
        else{
            return new Account();
        }
    }

    @GetMapping("/check-username")
    @ResponseBody
    public ResponseEntity<?> checkUsername(@RequestParam String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        if(account.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        else{
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Account> register(@RequestBody AccountDTO accountDTO) {

        Optional<Account> account = accountRepository.findByUsername(accountDTO.username);
        if (account.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Account newAccount = new Account(accountDTO.username, accountDTO.password,"customer", accountDTO.idUser);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }

    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/update-account")
    @ResponseBody
    public ResponseEntity<?> updateAccount(@RequestBody AccountDTO accountDTO) {
        Optional<Account> account = accountRepository.findById(accountDTO.id);
        if (account.isPresent()) {
            Account newAccount = new Account(accountDTO.id, accountDTO.username, accountDTO.password, "customer", accountDTO.idUser);
            accountRepository.save(newAccount);
            return ResponseEntity.ok(newAccount);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountDTO);
        }

    }

    @DeleteMapping("/delete-account")
    @ResponseBody
    public ResponseEntity<?> deleteAccount(@RequestParam int id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
