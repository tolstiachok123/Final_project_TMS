package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ManufacturerMapper {

    @Autowired
    private ModelMapper mapper;

    public ManufacturerDto objectToDto(Manufacturer manufacturer) {
        return Objects.isNull(manufacturer) ? null : mapper.map(manufacturer, ManufacturerDto.class);
    }

    public Manufacturer dtoToObject(ManufacturerDto manufacturerDto) {
        return Objects.isNull(manufacturerDto) ? null : mapper.map(manufacturerDto, Manufacturer.class);
    }

}
