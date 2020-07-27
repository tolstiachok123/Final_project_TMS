package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.ManufacturerDto;

import java.util.List;

public interface IManufacturerService {

    public List<ManufacturerDto> getAll();

    public ManufacturerDto getById(Integer id);

    public void update(Integer id, ManufacturerDto manufacturerDto);

    public void addNew(ManufacturerDto manufacturerDto);

    public void deleteById(Integer Id);

}
