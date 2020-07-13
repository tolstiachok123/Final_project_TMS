package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;
import com.test.demo.alcomarket.repository.IManufacturerRepository;
import com.test.demo.alcomarket.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements IManufacturerService {

    private IManufacturerRepository manufacturerRepository;

    @Autowired
    ManufacturerServiceImpl(IManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Integer id) {
        return manufacturerRepository.getOne(id);
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer, ManufacturerDto manufacturerDto) {
        manufacturer.setDescription(manufacturerDto.getDescription());
        manufacturer.setLink(manufacturerDto.getLink());
        manufacturer.setLogoPath(manufacturerDto.getLogoPath());
        manufacturer.setName(manufacturerDto.getName());
        manufacturerRepository.saveAndFlush(manufacturer);
        return manufacturer;
    }

    @Override
    public Manufacturer addNew(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setDescription(manufacturerDto.getDescription());
        manufacturer.setLink(manufacturerDto.getLink());
        manufacturer.setLogoPath(manufacturerDto.getLogoPath());
        manufacturer.setName(manufacturerDto.getName());
        manufacturerRepository.saveAndFlush(manufacturer);
        manufacturer = manufacturerRepository.findByName(manufacturerDto.getName());
        return manufacturer;
    }
}
