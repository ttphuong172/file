package com.example.be.service.impl;

import com.example.be.model.VanBanDen;
import com.example.be.repository.VanBanDenRepository;
import com.example.be.service.VanBanDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanBanDenServiceImpl implements VanBanDenService {
    @Autowired
    private VanBanDenRepository vanBanDenRepository;
    @Override
    public void save(VanBanDen vanBanDen) {
        vanBanDenRepository.save(vanBanDen);
    }

    @Override
    public List<VanBanDen> findAll() {
        return vanBanDenRepository.findAll();
    }

    @Override
    public VanBanDen findById(String id) {
        return vanBanDenRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(VanBanDen vanBanDen) {
        vanBanDenRepository.delete(vanBanDen);
    }
}
