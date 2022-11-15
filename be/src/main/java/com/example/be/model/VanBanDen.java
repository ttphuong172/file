package com.example.be.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VanBanDen {
    @Id
    private String id;
    private String soVanBanDen;
    private String tenVanBanDen;


    private LocalDate ngayPhatHanh;

    private LocalDateTime ngayDen;
    private String noiPhatHanh;
    private String tenTapTin;

    @ManyToOne
    @JoinColumn
    private Account account;
}
