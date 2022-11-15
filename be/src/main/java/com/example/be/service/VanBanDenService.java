package com.example.be.service;

import com.example.be.model.VanBanDen;

import java.util.List;

public interface VanBanDenService {
    void save(VanBanDen vanBanDen);
    List<VanBanDen> findAll();
    VanBanDen findById(String id);
    void delete(VanBanDen vanBanDen);

}
