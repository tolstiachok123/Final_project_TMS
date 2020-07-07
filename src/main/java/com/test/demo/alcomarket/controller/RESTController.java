package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RESTController {

    @Autowired
    private IAlcoholDrinkService alcoholDrinkService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/hello")
    public String helloPage() {
        return new String("This page for all? hello");
    }

    @RequestMapping(value = "/alcohol/all")
    public List<AlcoholDrink> showAllAlcoholDrinks() {
        return alcoholDrinkService.findAllAlcoholDrinks();
    }

    @RequestMapping(value = "/alcohol/one")
    public AlcoholDrink showAlcoholDrinkByName(@RequestParam(value = "name") String name) {
        return alcoholDrinkService.getAlcoholDrinkByName(name);
    }

    @RequestMapping(value = "/user/all")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/one")
    public User showUserByLogin(@RequestParam(value = "login") String username) {
        return userService.getUserByUsername(username);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }

}
