package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
//        List<DrinkListItemDTO> listDTOs = new ArrayList<>();
//        List<AlcoholDrink> drinkList = alcoholDrinkService.findAll();
//        for (int i = 0; i < drinkList.size(); i++) {
//            listDTOs.add(new DrinkListItemDTO(drinkList.get(i)));
//        }
//        return listDTOs;
        return alcoholDrinkService.findAll();
    }

    @GetMapping(value = "/drinks//{id}")
    public List<AlcoholDrink> addToBasket(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.addToBasket(id,
                ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return alcoholDrinkService.findAll();
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
