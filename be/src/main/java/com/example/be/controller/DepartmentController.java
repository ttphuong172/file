package com.example.be.controller;

import com.example.be.model.Department;
import com.example.be.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("")
    public ResponseEntity<List<Department>> findAll(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }
}
