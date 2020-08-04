package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.mapper.ManufacturerMapper;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IManufacturerService;
import com.test.demo.alcomarket.service.IOrderService;
import com.test.demo.alcomarket.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("/admin")
public class AdminController {

    private final IUserService userService;
    private final IAlcoholDrinkService alcoholDrinkService;
    private final IManufacturerService manufacturerService;
    private final IOrderService orderService;
    private final AlcoholDrinkMapper alcoholDrinkMapper;
    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    AdminController(IUserService userService, IAlcoholDrinkService alcoholDrinkService, IManufacturerService manufacturerService, IOrderService orderService, AlcoholDrinkMapper alcoholDrinkMapper, ManufacturerMapper manufacturerMapper) {
        this.userService = userService;
        this.alcoholDrinkService = alcoholDrinkService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
        this.alcoholDrinkMapper = alcoholDrinkMapper;
        this.manufacturerMapper = manufacturerMapper;
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
    public void deleteUserById(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(value = "/drinks")
    public void addNew(@RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrinkService.addNew(alcoholDrinkMapper.dtoToObject(alcoholDrinkDto));
    }

    @PutMapping(value = "/drinks/{id}")
    public void updateById(@PathVariable(name = "id") Integer id, @RequestBody AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrinkService.update(id, alcoholDrinkMapper.dtoToObject(alcoholDrinkDto));
    }

    @DeleteMapping(value = "/drinks/{id}")
    public void deleteAlcoholDrinkById(@PathVariable(name = "id") Integer id) {
        alcoholDrinkService.deleteById(id);
    }

    @PostMapping(value = "/manufacturer")
    public void addNew(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.addNew(manufacturerMapper.dtoToObject(manufacturerDto));
    }

    @PutMapping(value = "/manufacturers/{id}")
    public void updateById(@PathVariable(name = "id") Integer id, @RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.update(id, manufacturerMapper.dtoToObject(manufacturerDto));
    }

    @DeleteMapping(value = "/manufacturers/{id}")
    public void deleteManufacturerById(@PathVariable(name = "id") Integer id) {
        manufacturerService.deleteById(id);
    }

    @DeleteMapping(value = "/order/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        orderService.deleteById(id);
    }

}
