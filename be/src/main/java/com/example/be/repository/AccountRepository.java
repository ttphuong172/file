package com.example.be.repository;

import com.example.be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String> {
    List<Account> findAccountsByDepartment_Id(int id);
}
