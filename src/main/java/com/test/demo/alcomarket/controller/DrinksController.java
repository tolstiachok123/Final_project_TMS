package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DrinksController {

    private final IAlcoholDrinkService alcoholDrinkService;
    private final AlcoholDrinkMapper alcoholDrinkMapper;

    @Autowired
    DrinksController(IAlcoholDrinkService alcoholDrinkService, AlcoholDrinkMapper alcoholDrinkMapper) {
        this.alcoholDrinkService = alcoholDrinkService;
        this.alcoholDrinkMapper = alcoholDrinkMapper;
    }

    @GetMapping(value = "/drinks")
    public List<AlcoholDrinkDto> showAll() {
        return alcoholDrinkService.findAll();
    }

    @PostMapping(value = "/drinks/{id}/basket")
    public void addToBasket(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.addToBasket(id);
    }

    @GetMapping(value = "/drinks/{id}")
    public AlcoholDrinkDto showById(@PathVariable(name = "id") Integer id) {
        return alcoholDrinkMapper.objectToDto(alcoholDrinkService.findById(id));
    }

}
