package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.mapper.ManufacturerMapper;
import com.test.demo.alcomarket.model.Manufacturer;
import com.test.demo.alcomarket.repository.IManufacturerRepository;
import com.test.demo.alcomarket.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ManufacturerServiceImpl implements IManufacturerService {

    private IManufacturerRepository manufacturerRepository;
    private ManufacturerMapper manufacturerMapper;

    @Autowired
    ManufacturerServiceImpl(IManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    @Override
    public List<ManufacturerDto> getAll() {
        List<ManufacturerDto> manufacturerDtos = new ArrayList<ManufacturerDto>();
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerDtos.add(manufacturerMapper.objectToDto(manufacturer));
        }
        return manufacturerDtos;
    }

    @Override
    public ManufacturerDto getById(Integer id) {
        return manufacturerMapper.objectToDto(manufacturerRepository.getOne(id));
    }

    @Override
    public void update(Integer id, ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = manufacturerRepository.getOne(id);
        manufacturerRepository.saveAndFlush(manufacturerMapper.dtoToObject(manufacturerDto, manufacturer));
    }

    @Override
    public void addNew(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer =manufacturerMapper.dtoToObject(manufacturerDto, new Manufacturer());
        manufacturerRepository.saveAndFlush(manufacturer);
    }

    @Override
    public void deleteById(Integer id) {
        manufacturerRepository.deleteById(id);
    }
}
