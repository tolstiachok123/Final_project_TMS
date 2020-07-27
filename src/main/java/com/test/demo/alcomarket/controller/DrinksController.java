package com.test.demo.alcomarket.controller;

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

    @PostMapping(value = "/drinks/{id}/basket")
    public void addToBasket(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.addToBasket(id);
    }

    @GetMapping(value = "/drinks/{id}")
    public AlcoholDrink showById(@PathVariable(name = "id") Integer id) {
        return alcoholDrinkService.findById(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }

}
