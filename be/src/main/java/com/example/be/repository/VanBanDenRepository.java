package com.example.be.repository;

import com.example.be.model.VanBanDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VanBanDenRepository extends JpaRepository<VanBanDen, String> {
    @Query("select v from VanBanDen v order by v.ngayDen DESC")
    List<VanBanDen> findAll();
}
