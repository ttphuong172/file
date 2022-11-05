package com.example.be.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload {
    @Id
    private String id;
    private String name;
    private int year;
    private String fileName;
}
