package com.example.be.controller;

import com.example.be.model.Account;
import com.example.be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("")
    public ResponseEntity<List<Account>> findAll(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{username}")
    public ResponseEntity<Account> findById(@PathVariable String username){
        return new ResponseEntity<>(accountService.findById(username),HttpStatus.OK);
    }
}
