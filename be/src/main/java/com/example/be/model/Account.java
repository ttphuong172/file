package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    List<VanBanDen> vanBanDenList;
}