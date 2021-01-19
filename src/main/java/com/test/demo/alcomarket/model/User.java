package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Column
  private String email;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String username;
  @Column
  private String phone;
  @Column
  private String password;
  @Column
  private boolean active;
  @CreatedDate
  @Column
  private Date created;
  @LastModifiedDate
  @Column
  private Date updated;
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  private List<Order> orders;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  private List<Role> roles;

}
