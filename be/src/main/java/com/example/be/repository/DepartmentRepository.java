package com.example.be.repository;

import com.example.be.model.Account;
import com.example.be.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
