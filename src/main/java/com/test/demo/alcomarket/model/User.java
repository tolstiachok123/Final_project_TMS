package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Order> orders;
}
