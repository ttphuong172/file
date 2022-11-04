package com.example.be.service.impl;

import com.example.be.model.FileUpload;
import com.example.be.repository.FileUploadRepository;
import com.example.be.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;
    @Override
    public void save(FileUpload fileUpload) {
        fileUploadRepository.save(fileUpload);
    }
}
