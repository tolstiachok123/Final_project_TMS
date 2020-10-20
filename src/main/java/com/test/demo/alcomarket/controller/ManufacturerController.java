package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.mapper.ManufacturerMapper;
import com.test.demo.alcomarket.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturerController {

    private final IManufacturerService manufacturerService;
    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    ManufacturerController(IManufacturerService manufacturerService, ManufacturerMapper manufacturerMapper) {
        this.manufacturerService = manufacturerService;
        this.manufacturerMapper = manufacturerMapper;
    }

    @GetMapping(value = "/manufacturers")
    public List<ManufacturerDto> showAll() {
        return manufacturerService.getAll();
    }

    @GetMapping(value = "/manufacturers/{id}")
    public ManufacturerDto showById(@PathVariable(name = "id") Integer id) {
        return manufacturerMapper.objectToDto(manufacturerService.getById(id));
    }

}
