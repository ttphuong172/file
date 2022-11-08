package com.example.be.controller;

import com.example.be.model.FileUpload;
import com.example.be.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/files")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("file") MultipartFile file) {
        String message="";
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Id:" +id);
        System.out.println("Name: " + name);
        System.out.println("File:"+file.getOriginalFilename());

        String currentDir = System.getProperty("user.dir");

        String uri= currentDir + "/uploads" + "\\" + LocalDate.now().getYear() + "\\" + LocalDate.now().getMonthValue() + "\\" + id;

        try {
            Files.createDirectories(Paths.get(uri));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.copy(file.getInputStream(), Paths.get(String.valueOf(uri)).resolve(file.getOriginalFilename()));
        } catch (FileAlreadyExistsException e){
            message="File da ton tai";
            System.out.println(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);

//        StringBuilder currentDir = new StringBuilder(System.getProperty("user.dir"));
//        int currentYear = LocalDate.now().getYear();
//        currentDir.delete(currentDir.length()-2,currentDir.length());
//        currentDir.append("\\webapps\\qlvb\\assets\\images\\" + currentYear+"\\"+ id);
//
//        try {
//            Files.createDirectories(Paths.get(String.valueOf(currentDir)));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Files.copy(file.getInputStream(), Paths.get(String.valueOf(currentDir)).resolve(file.getOriginalFilename()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileUpload fileUpload = new FileUpload(id,name,currentYear,file.getOriginalFilename());
//        fileUploadService.save(fileUpload);
//
//        return new ResponseEntity<>(String.valueOf(currentDir),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<FileUpload>> findAll() {
        return new ResponseEntity<>(fileUploadService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {

        StringBuilder currentDir = new StringBuilder(System.getProperty("user.dir"));
        int currentYear = LocalDate.now().getYear();
//        currentDir.delete(currentDir.length()-2,currentDir.length());
        currentDir.append("\\webapps\\qlvb\\assets\\images\\" + currentYear + "\\" + id);

        FileUpload fileUpload = fileUploadService.findById(id);

        System.out.println(fileUpload.getYear());
        System.out.println(fileUpload.getFileName());

        try {
            Files.delete(Paths.get(currentDir + "\\" + fileUpload.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
