package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;
import com.test.demo.alcomarket.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {

    private IManufacturerService manufacturerService;

    @Autowired
    ManufacturerController(IManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping(value = "/manufacturers")
    public List<Manufacturer> showAll() {
        return manufacturerService.findAll();
    }

    @GetMapping(value = "/manufacturers/{id}")
    public Manufacturer showById(@PathVariable(name = "id") Integer id) {
        return manufacturerService.findById(id);
    }

    @PutMapping(value = "/manufacturers/{id}")
    public Manufacturer updateById(@PathVariable(name = "id") Integer id, @RequestBody ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        return manufacturerService.update(manufacturer, manufacturerDto);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
