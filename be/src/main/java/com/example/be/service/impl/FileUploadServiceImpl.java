package com.example.be.service.impl;

import com.example.be.model.FileUpload;
import com.example.be.repository.FileUploadRepository;
import com.example.be.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;
    @Override
    public void save(FileUpload fileUpload) {
        fileUploadRepository.save(fileUpload);
    }

    @Override
    public List<FileUpload> findAll() {
        return fileUploadRepository.findAll();
    }

    @Override
    public FileUpload findById(Integer id) {
        return fileUploadRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(FileUpload fileUpload) {
        fileUploadRepository.delete(fileUpload);
    }
}
