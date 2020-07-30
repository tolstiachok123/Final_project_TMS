package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IManufacturerService;
import com.test.demo.alcomarket.service.IOrderService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/admin")
public class AdminController {

    private IUserService userService;
    private IAlcoholDrinkService alcoholDrinkService;
    private IManufacturerService manufacturerService;
    private IOrderService orderService;

    @Autowired
    AdminController(IUserService userService, IAlcoholDrinkService alcoholDrinkService, IManufacturerService manufacturerService, IOrderService orderService) {
        this.userService = userService;
        this.alcoholDrinkService = alcoholDrinkService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }

    @GetMapping(value = "/users")
    public List<UserDto> showAll() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public UserDto showById(@PathVariable(name = "id") Integer id) {
        return userService.getOne(id);
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUserById(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
        return "User deleted successfully!";
    }

    @PostMapping(value = "/drinks")
    public void addNew(@RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrinkService.addNew(alcoholDrinkDto);
    }

    @PutMapping(value = "/drinks/{id}")
    public void updateById(@PathVariable(name = "id") Integer id, @RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrinkService.update(id, alcoholDrinkDto); //В метожде update сделать проверку и копирование ТОЛЬКО измененных полей
    }

    @DeleteMapping(value = "/drinks/{id}")
    public String deleteAlcoholDrinkById(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.deleteById(id);
        return "Alcohol drink deleted successfully!";
    }

    @PostMapping(value = "/manufacturer")
    public void addNew(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.addNew(manufacturerDto);
    }

    @DeleteMapping(value = "/manufacturers/{id}")
    public String deleteManufacturerById(@PathVariable(name = "id") Integer id) {
        manufacturerService.deleteById(id);
        return "Manufacturer deleted successfully!";
    }

    @DeleteMapping(value = "/order/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        orderService.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
