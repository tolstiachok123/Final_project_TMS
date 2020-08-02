package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;

import java.util.List;

public interface IAlcoholDrinkService {

    public List<AlcoholDrinkDto> findAll();

    public AlcoholDrink findById(Integer id);

    public void update(Integer drinkId, AlcoholDrink alcoholDrink);

    public void addNew(AlcoholDrink alcoholDrink);

    public void deleteById(Integer id);

    public void addToBasket(Integer Id);
}
