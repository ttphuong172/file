package com.example.be.service;

import com.example.be.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(String usernamr);
}