package com.example.be.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VanBanDen {
    @Id
    private Integer id;
    private String soVanBanDen;
    private String tenVanBanDen;


    private LocalDate ngayPhatHanh;

    private LocalDate ngayDen;
    private String noiPhatHanh;
    private String tenTapTin;
}
