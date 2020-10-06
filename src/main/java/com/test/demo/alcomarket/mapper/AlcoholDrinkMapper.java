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
//        AlcoholDrink alcoholDrink = new AlcoholDrink();
//        alcoholDrink.setAdv(alcoholDrinkDto.getAdv());
//        alcoholDrink.setCost(alcoholDrinkDto.getCost());
//        alcoholDrink.setName(alcoholDrinkDto.getName());
//        alcoholDrink.setPhotoPath(alcoholDrinkDto.getPhotoPath());
//        alcoholDrink.setQuantity(alcoholDrinkDto.getQuantity());
//        alcoholDrink.setType(alcoholDrinkDto.getType());
//        return alcoholDrink;
        return Objects.isNull(alcoholDrinkDto) ? null : mapper.map(alcoholDrinkDto, AlcoholDrink.class);
    }

    public AlcoholDrinkDto objectToDto(AlcoholDrink alcoholDrink) {
//        AlcoholDrinkDto alcoholDrinkDto = new AlcoholDrinkDto();
//        alcoholDrinkDto.setAdv(alcoholDrink.getAdv());
//        alcoholDrinkDto.setCost(alcoholDrink.getCost());
//        alcoholDrinkDto.setName(alcoholDrink.getName());
//        alcoholDrinkDto.setPhotoPath(alcoholDrink.getPhotoPath());
//        alcoholDrinkDto.setQuantity(alcoholDrink.getQuantity());
//        alcoholDrinkDto.setType(alcoholDrink.getType());
//        return alcoholDrinkDto;
        return Objects.isNull(alcoholDrink) ? null : mapper.map(alcoholDrink, AlcoholDrinkDto.class);
    }

}
