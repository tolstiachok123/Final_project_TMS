package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlcoholDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String photoPath;
    @Column
    @Enumerated(EnumType.STRING)
    private AlcoholDrinkType type;
    @Column
    private int quantity;
    @Column
    private String name;
    @Column
    private double cost;
    @Column
    private double adv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", insertable=false, updatable=false)
    private Manufacturer manufacturer;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Order> orders;
}
