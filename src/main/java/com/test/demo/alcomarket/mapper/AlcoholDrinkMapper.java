package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.service.impl.ManufacturerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlcoholDrinkMapper {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private ManufacturerServiceImpl manufacturerService;

  public AlcoholDrink dtoToObject(AlcoholDrinkDto alcoholDrinkDto) {
    AlcoholDrink alcoholDrink = mapper.map(alcoholDrinkDto, AlcoholDrink.class);
    alcoholDrink.setManufacturer(manufacturerService.getByName(alcoholDrinkDto.getManufacturerName()));
    return alcoholDrink;
  }

  public AlcoholDrinkDto objectToDto(AlcoholDrink alcoholDrink) {
    return mapper.map(alcoholDrink, AlcoholDrinkDto.class);
  }

}
