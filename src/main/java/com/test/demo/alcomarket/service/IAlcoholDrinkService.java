package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.model.AlcoholDrink;

import java.util.List;

public interface IAlcoholDrinkService {

    public List<AlcoholDrink> findAllAlcoholDrinks();

    public AlcoholDrink getAlcoholDrinkByName(String name);
}
