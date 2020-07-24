package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;

import java.util.List;

public interface IManufacturerService {

    public List<Manufacturer> findAll();

    public Manufacturer findById(Integer id);

    public Manufacturer update(Manufacturer manufacturer, ManufacturerDto manufacturerDto);

    public Manufacturer addNew(ManufacturerDto manufacturerDto);

    public void deleteById(Integer Id);

}
