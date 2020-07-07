package com.test.demo.alcomarket.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleName name;


    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
