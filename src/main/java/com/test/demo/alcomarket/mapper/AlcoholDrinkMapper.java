package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import org.springframework.stereotype.Service;

@Service
public class AlcoholDrinkMapper {

    public AlcoholDrink DtoToObject(AlcoholDrinkDto alcoholDrinkDto, AlcoholDrink alcoholDrink) {
        alcoholDrink.setAdv(alcoholDrinkDto.getAdv());
        alcoholDrink.setCost(alcoholDrinkDto.getCost());
        alcoholDrink.setName(alcoholDrinkDto.getName());
        alcoholDrink.setPhotoPath(alcoholDrinkDto.getPhotoPath());
        alcoholDrink.setQuantity(alcoholDrinkDto.getQuantity());
        alcoholDrink.setType(alcoholDrinkDto.getType());
        return alcoholDrink;
    }

    public AlcoholDrinkDto ObjectToDto(AlcoholDrink alcoholDrink) {
        AlcoholDrinkDto alcoholDrinkDto = new AlcoholDrinkDto();
        alcoholDrinkDto.setAdv(alcoholDrink.getAdv());
        alcoholDrinkDto.setCost(alcoholDrink.getCost());
        alcoholDrinkDto.setName(alcoholDrink.getName());
        alcoholDrinkDto.setPhotoPath(alcoholDrink.getPhotoPath());
        alcoholDrinkDto.setQuantity(alcoholDrink.getQuantity());
        alcoholDrinkDto.setType(alcoholDrink.getType());
        return alcoholDrinkDto;
    }

}
