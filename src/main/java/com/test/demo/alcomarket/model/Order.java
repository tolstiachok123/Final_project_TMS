package com.test.demo.alcomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private boolean status;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private List<AlcoholDrink> alcoholDrinks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", alcoholDrinks=" + alcoholDrinks +
                '}';
    }
}
