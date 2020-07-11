package com.test.demo.alcomarket.dto;

import com.test.demo.alcomarket.model.AlcoholDrinkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlcoholDrinkDto {

    private String photoPath;
    private AlcoholDrinkType type;
    private int quantity;
    private String name;
    private double cost;
    private double adv;

}
