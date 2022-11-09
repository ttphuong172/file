package com.example.be.service;

import com.example.be.model.FileUpload;

import java.util.List;
import java.util.UUID;

public interface FileUploadService {
    void save(FileUpload fileUpload);
    List<FileUpload> findAll();
    FileUpload findById(Integer id);
    void delete(FileUpload fileUpload);

}
