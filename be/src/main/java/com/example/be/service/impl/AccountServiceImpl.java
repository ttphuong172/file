package com.example.be.service.impl;

import com.example.be.model.Account;
import com.example.be.repository.AccountRepository;
import com.example.be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).orElse(null);
    }
}
