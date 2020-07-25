package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Manufacturer;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IManufacturerService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/admin")
public class AdminController {

    private IUserService userService;
    private IAlcoholDrinkService alcoholDrinkService;
    private IManufacturerService manufacturerService;

    @Autowired
    AdminController(IUserService userService, IAlcoholDrinkService alcoholDrinkService, IManufacturerService manufacturerService) {
        this.userService = userService;
        this.alcoholDrinkService = alcoholDrinkService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping(value = "/users")
    public List<User> showAll() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User showById(@PathVariable(name = "id") Integer id) {
        return userService.getOne(id);
    }

    @PutMapping(value = "/users/{id}")
    public User disableById(@PathVariable(name = "id") Integer id, @RequestBody UserDto userDto) {
        User user = userService.getOne(id);
        return userService.disable(user, userDto);
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUserById(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
        return "User deleted successfully!";
    }

    @PostMapping(value = "/drinks")
    public AlcoholDrink addNew(@RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        AlcoholDrink alcoholDrink = new AlcoholDrink();
        return alcoholDrinkService.addNew(alcoholDrink, alcoholDrinkDto);
    }

    @PutMapping(value = "/drinks/{id}")
    public AlcoholDrink updateById(@PathVariable(name = "id") Integer id, @RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        AlcoholDrink alcoholDrink = alcoholDrinkService.findById(id);
        return alcoholDrinkService.update(alcoholDrink, alcoholDrinkDto); //В метожде update сделать проверку и копирование ТОЛЬКО измененных полей
    }

    @DeleteMapping(value = "/drinks/{id}")
    public String deleteAlcoholDrinkById(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.deleteById(id);
        return "Alcohol drink deleted successfully!";
    }

    @PostMapping(value = "/manufacturer")
    public Manufacturer addNew(@RequestBody ManufacturerDto manufacturerDto) {
        return manufacturerService.addNew(manufacturerDto);
    }

    @DeleteMapping(value = "/manufacturers/{id}")
    public String deleteManufacturerById(@PathVariable(name = "id") Integer id) {
        manufacturerService.deleteById(id);
        return "Manufacturer deleted successfully!";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
