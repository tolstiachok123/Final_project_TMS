package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.mapper.ManufacturerMapper;
import com.test.demo.alcomarket.service.IManufacturerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @PutMapping(value = "/manufacturers/{id}")
    public void updateById(@PathVariable(name = "id") Integer id, @RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.update(id, manufacturerMapper.dtoToObject(manufacturerDto));
    }

}
