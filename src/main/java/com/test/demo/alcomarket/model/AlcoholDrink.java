package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Order> orders;

    @Override
    public String toString() {
        return "AlcoholDrink{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                ", type=" + type +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", adv=" + adv +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
