package com.example.be.service;

import com.example.be.model.FileUpload;

import java.util.List;

public interface FileUploadService {
    void save(FileUpload fileUpload);
    List<FileUpload> findAll();
    FileUpload findById(String id);

}
