package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String link;

    @Column
    private String logoPath;
//
//    @OneToMany(mappedBy = "manufacturer", fetch=FetchType.LAZY)
//    private List<AlcoholDrink> alcoholDrinks;

}
