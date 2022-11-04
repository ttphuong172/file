package com.example.be.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/files")
public class FileUploadController {
    @PostMapping("upload")
    public ResponseEntity<String> upload (@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("file") MultipartFile file){

        StringBuilder currentDir = new StringBuilder(System.getProperty("user.dir"));
        currentDir.delete(currentDir.length()-2,currentDir.length());
        System.out.println(currentDir);
        currentDir.append("fe");
        System.out.println(currentDir);


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
