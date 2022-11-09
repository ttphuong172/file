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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/files")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    //    Khi chay local
    String currentDir = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() - 3).concat("\\fe\\src\\assets\\upload\\");

//    Khi build tren server
//    String currentDir = System.getProperty("user.dir").concat("\\webapps\\qlvb\\assets\\upload\\") ;

    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("soCongVan") String soCongVan, @RequestParam("tenCongVan") String tenCongVan, @RequestParam("file") MultipartFile file) {
        Integer id;
        List<FileUpload> fileUploadList = fileUploadService.findAll();
        if(fileUploadList.size()==0){
            id=1;
        } else {
            System.out.println(fileUploadList.get(fileUploadList.size()-1).getId());
            id = fileUploadList.get(fileUploadList.size()-1).getId() + 1;
        }

        String fileDir = currentDir.concat(LocalDate.now().getYear() + "\\" + id);


//        Tao thu muc
        try {
            Files.createDirectories(Paths.get(fileDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Chep file
        try {
            Files.copy(file.getInputStream(), Paths.get(fileDir).resolve(file.getOriginalFilename()));
        } catch (FileAlreadyExistsException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Luu vao CSDL
        FileUpload fileUpload = new FileUpload();
        fileUpload.setId(id);
        fileUpload.setSoCongVan(soCongVan);
        fileUpload.setTenCongVan(tenCongVan);
        fileUpload.setNam(LocalDate.now().getYear());
        fileUpload.setTenFile(file.getOriginalFilename());
        fileUploadService.save(fileUpload);

        return new ResponseEntity<>(HttpStatus.OK);


    }

    @GetMapping("{id}")
    public ResponseEntity<FileUpload> findById(@PathVariable Integer id) {
        System.out.println(id);
        FileUpload fileUpload = fileUploadService.findById(id);
        System.out.println(fileUpload);
        return new ResponseEntity<>(fileUploadService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {

        FileUpload fileUpload = fileUploadService.findById(id);

        String fileDir = currentDir.concat(fileUpload.getNam() + "\\" + fileUpload.getId());
        System.out.println(fileDir);

//Xoa File
        try {
            Files.delete(Paths.get(fileDir + "\\" + fileUpload.getTenFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
//Xoa thu muc
        try {
            Files.delete(Paths.get(fileDir));
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileUploadService.delete(fileUpload);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<List<FileUpload>> findAll() {
        return new ResponseEntity<>(fileUploadService.findAll(), HttpStatus.OK);
    }


}
