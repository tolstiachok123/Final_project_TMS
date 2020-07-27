package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;

import java.util.List;

public interface IAlcoholDrinkService {

    public List<AlcoholDrinkDto> findAll();

    public AlcoholDrink findById(Integer id);

    public void update(Integer drinkId, AlcoholDrinkDto alcoholDrinkDto);

    public void addNew(AlcoholDrinkDto alcoholDrinkDto);

    public void deleteById(Integer id);

    public void addToBasket(Integer alcoholId);
}
