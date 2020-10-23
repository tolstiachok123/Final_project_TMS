package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {

    @Autowired
    private ModelMapper mapper;

    public ManufacturerDto objectToDto(Manufacturer manufacturer) {
        return mapper.map(manufacturer, ManufacturerDto.class);
    }

    public Manufacturer dtoToObject(ManufacturerDto manufacturerDto) {
        return mapper.map(manufacturerDto, Manufacturer.class);
    }

}
