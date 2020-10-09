package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AlcoholDrinkMapper {

    @Autowired
    private ModelMapper mapper;

    public AlcoholDrink dtoToObject(AlcoholDrinkDto alcoholDrinkDto) {
        return Objects.isNull(alcoholDrinkDto) ? null : mapper.map(alcoholDrinkDto, AlcoholDrink.class);
    }

    public AlcoholDrinkDto objectToDto(AlcoholDrink alcoholDrink) {
        return Objects.isNull(alcoholDrink) ? null : mapper.map(alcoholDrink, AlcoholDrinkDto.class);
    }

}
