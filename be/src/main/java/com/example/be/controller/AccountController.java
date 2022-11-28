package com.example.be.controller;

import com.example.be.model.Account;
import com.example.be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("")
    public ResponseEntity<List<Account>> findAll(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{username}")
    public ResponseEntity<Account> findById(@PathVariable String username){
        return new ResponseEntity<>(accountService.findById(username),HttpStatus.OK);
    }

    @GetMapping("reset/{username}")
    public ResponseEntity <String> resetPassword(@PathVariable String username){
        Account account = accountService.findById(username);

        account.setPassword(bCryptPasswordEncoder.encode("123456"));

        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{username}")
    public ResponseEntity<String> update(@PathVariable String username, @RequestBody Account account){
        Account currentAccount = accountService.findById(username);

        currentAccount.setName(account.getName());
        currentAccount.setRole(account.getRole());
        currentAccount.setDepartment(account.getDepartment());
        accountService.save(currentAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Account account){
        account.setPassword(bCryptPasswordEncoder.encode("123456"));
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("department/{id}")
    public ResponseEntity<List<Account>> findAccountsByDepartment_Id(@PathVariable int id){
        return new ResponseEntity<>(accountService.findAccountsByDepartment_Id(id),HttpStatus.OK);
    }
}
