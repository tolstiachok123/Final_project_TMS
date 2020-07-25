package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;

import java.util.List;

public interface IAlcoholDrinkService {

    public List<AlcoholDrink> findAll();

    public AlcoholDrink findByName(String name);

    public AlcoholDrink findById(Integer id);

    public AlcoholDrink update(AlcoholDrink alcoholDrink, AlcoholDrinkDto alcoholDrinkDto);

    public AlcoholDrink addNew(AlcoholDrink alcoholDrink, AlcoholDrinkDto alcoholDrinkDto);

    public void deleteById(Integer id);

    public void addToBasket(Integer alcoholId, Integer userId);
}
