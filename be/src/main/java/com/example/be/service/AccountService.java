package com.example.be.service;

import com.example.be.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(String username);
    void save(Account account);
    List<Account> findAccountsByDepartment_Id(int id);
}
