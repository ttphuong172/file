package com.example.be.controller;

import com.example.be.model.FileUpload;
import com.example.be.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/files")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("upload")
    public ResponseEntity<String> upload (@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("file") MultipartFile file){

        StringBuilder currentDir = new StringBuilder(System.getProperty("user.dir"));
        currentDir.delete(currentDir.length()-2,currentDir.length());
        currentDir.append("fe\\src\\assets\\images");

        try {
            Files.copy(file.getInputStream(), Paths.get(String.valueOf(currentDir)).resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUpload fileUpload = new FileUpload(id,name,"assets\\images" + "\\" + file.getOriginalFilename());
        fileUploadService.save(fileUpload);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<FileUpload>> findAll(){
        return new ResponseEntity<>(fileUploadService.findAll(),HttpStatus.OK);
    }

}
