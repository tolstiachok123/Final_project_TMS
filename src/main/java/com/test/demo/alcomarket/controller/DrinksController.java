package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrinksController {

    private IAlcoholDrinkService alcoholDrinkService;

    @Autowired
    DrinksController(IAlcoholDrinkService alcoholDrinkService) {
        this.alcoholDrinkService = alcoholDrinkService;
    }

    @GetMapping(value = "/drinks")
    public List<AlcoholDrink> showAll() {
        return alcoholDrinkService.findAll();
    }

    @GetMapping(value = "/drinks/{id}")
    public AlcoholDrink showById(@PathVariable(name = "id") Integer id) {
        return alcoholDrinkService.findById(id);
    }

    @PutMapping(value = "/drinks/{id}")
    public AlcoholDrink updateById(@PathVariable(name = "id") Integer id,
                                               @RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        AlcoholDrink alcoholDrink = alcoholDrinkService.findById(id);
        return alcoholDrinkService.update(alcoholDrink, alcoholDrinkDto); //В метожде update сделать проверку и копирование ТОЛЬКО измененных полей
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }

}
