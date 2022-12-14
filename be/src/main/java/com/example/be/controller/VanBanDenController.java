package com.example.be.controller;

import com.example.be.model.Account;
import com.example.be.model.VanBanDen;
import com.example.be.service.AccountService;
import com.example.be.service.VanBanDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/vanbandens")
@CrossOrigin
public class VanBanDenController {
    @Autowired
    private VanBanDenService vanBanDenService;
    @Autowired
            private AccountService accountService;

    //    Khi chay local
    String currentDir = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() - 3).concat("\\fe\\src\\assets\\upload\\");

//    Khi build tren server
//    String currentDir = System.getProperty("user.dir").concat("\\webapps\\qlvb\\assets\\upload\\") ;

    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("soVanBanDen") String soVanBanDen, @RequestParam("noiPhatHanh") String noiPhatHanh, @RequestParam("ngayPhatHanh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayPhatHanh, @RequestParam("tenVanBanDen") String tenVanBanDen, @RequestParam("account")String account, @RequestParam("file") MultipartFile file) {

        String id = UUID.randomUUID().toString();

        String fileDir = currentDir.concat(String.valueOf(id));

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
        VanBanDen vanBanDen = new VanBanDen();
        vanBanDen.setId(id);
        vanBanDen.setSoVanBanDen(soVanBanDen);
        vanBanDen.setTenVanBanDen(tenVanBanDen);
        vanBanDen.setNoiPhatHanh(noiPhatHanh);
        vanBanDen.setNgayPhatHanh(ngayPhatHanh);
        vanBanDen.setAccount(this.accountService.findById(account));
        vanBanDen.setNgayDen(LocalDateTime.now());
        vanBanDen.setTenTapTin(file.getOriginalFilename());
        vanBanDenService.save(vanBanDen);

        return new ResponseEntity<>(HttpStatus.OK);


    }

    @GetMapping("{id}")
    public ResponseEntity<VanBanDen> findById(@PathVariable String id) {
        VanBanDen vanBanDen= vanBanDenService.findById(id);
        if (vanBanDen==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vanBanDen, HttpStatus.OK);
    }

//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
//
//        FileUpload fileUpload = fileUploadService.findById(id);
//
//        if(fileUpload == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        String fileDir = currentDir.concat(fileUpload.getNam() + "\\" + fileUpload.getId());
//        System.out.println(fileDir);
//
////      Xoa File
//        try {
//            Files.delete(Paths.get(fileDir + "\\" + fileUpload.getTenFile()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////      Xoa thu muc
//        try {
//            Files.delete(Paths.get(fileDir));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        fileUploadService.delete(fileUpload);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    @GetMapping("")
    public ResponseEntity<List<VanBanDen>> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(auth.getName());

        return new ResponseEntity<>(vanBanDenService.findAll(), HttpStatus.OK);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<String> update(@PathVariable Integer id,@RequestParam("soCongVan") String soCongVan,@RequestParam("tenCongVan") String tenCongVan){
//        FileUpload fileUpload = fileUploadService.findById(id);
//
//        fileUpload.setSoCongVan(soCongVan);
//        fileUpload.setTenCongVan(tenCongVan);
//
//        fileUploadService.save(fileUpload);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
