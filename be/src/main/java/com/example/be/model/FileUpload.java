package com.example.be.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload {
    @Id
    private Integer id;
    private String soCongVan;
    private String tenCongVan;
    private int nam;
    private String tenFile;
}
