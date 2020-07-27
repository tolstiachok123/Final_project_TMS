package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.ManufacturerDto;
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
    public List<ManufacturerDto> showAll() {
        return manufacturerService.getAll();
    }

    @GetMapping(value = "/manufacturers/{id}")
    public ManufacturerDto showById(@PathVariable(name = "id") Integer id) {
        return manufacturerService.getById(id);
    }

    @PutMapping(value = "/manufacturers/{id}")
    public void updateById(@PathVariable(name = "id") Integer id, @RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.update(id, manufacturerDto);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
