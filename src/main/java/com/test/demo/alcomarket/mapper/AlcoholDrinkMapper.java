package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlcoholDrinkMapper {

    @Autowired
    private ModelMapper mapper;

    public AlcoholDrink dtoToObject(AlcoholDrinkDto alcoholDrinkDto) {
        return mapper.map(alcoholDrinkDto, AlcoholDrink.class);
    }

    public AlcoholDrinkDto objectToDto(AlcoholDrink alcoholDrink) {
        return mapper.map(alcoholDrink, AlcoholDrinkDto.class);
    }

}
