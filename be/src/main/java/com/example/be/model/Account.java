package com.example.be.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private String username;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToOne
    @JoinColumn
    private Department department;
}