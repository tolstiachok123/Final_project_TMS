//package com.test.demo.alcomarket.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ManyToMany(mappedBy = "orders")
//    private List<AlcoholDrink> alcoholDrinks;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", insertable = false, updatable = false)
//    private User user;
//}
