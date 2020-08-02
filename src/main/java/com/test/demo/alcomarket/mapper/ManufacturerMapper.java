package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerMapper {

    public ManufacturerDto objectToDto(Manufacturer manufacturer) {
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        manufacturerDto.setDescription(manufacturer.getDescription());
        manufacturerDto.setLink(manufacturer.getLink());
        manufacturerDto.setLogoPath(manufacturer.getLogoPath());
        manufacturerDto.setName(manufacturer.getName());
        return manufacturerDto;
    }

    public Manufacturer dtoToObject(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setDescription(manufacturerDto.getDescription());
        manufacturer.setLink(manufacturerDto.getLink());
        manufacturer.setLogoPath(manufacturerDto.getLogoPath());
        manufacturer.setName(manufacturerDto.getName());
        return manufacturer;
    }

}
