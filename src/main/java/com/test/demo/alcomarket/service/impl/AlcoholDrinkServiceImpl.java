package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.repository.AlcoholDrinkRepository;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholDrinkServiceImpl implements IAlcoholDrinkService {

    private AlcoholDrinkRepository alcoholDrinkRepository;

    @Autowired
    AlcoholDrinkServiceImpl(AlcoholDrinkRepository alcoholDrinkRepository) {
        this.alcoholDrinkRepository = alcoholDrinkRepository;
    }

    @Override
    public List<AlcoholDrink> findAllAlcoholDrinks() {
        return alcoholDrinkRepository.findAll();
    }

    @Override
    public AlcoholDrink getAlcoholDrinkByName(String name) {
        return alcoholDrinkRepository.findByName(name);
    }


}
