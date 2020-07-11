package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinTable(name = "manufacturer_alcoholdrink",
            joinColumns = {@JoinColumn(name = "manufacturerid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "alcoholdrinkid", referencedColumnName = "id")})
    private List<AlcoholDrink> alcoholDrinks;

}
