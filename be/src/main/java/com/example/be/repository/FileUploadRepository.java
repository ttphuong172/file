package com.example.be.repository;

import com.example.be.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer> {

}
