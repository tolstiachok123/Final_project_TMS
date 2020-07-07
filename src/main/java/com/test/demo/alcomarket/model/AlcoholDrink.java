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
    private Integer alcoholDrinkId;

    @Column
    private String photoPath;

    @Column
    private String type;

    @Column
    private int quantity;

    @Column
    private String name;

    @Column
    private double cost;

    @Column
    private double adv;
}
