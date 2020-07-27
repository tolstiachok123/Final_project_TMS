package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapper {

    private AlcoholDrinkMapper alcoholDrinkMapper;

    OrderMapper(AlcoholDrinkMapper alcoholDrinkMapper) {
        this.alcoholDrinkMapper = alcoholDrinkMapper;
    }

    public OrderDto objectToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        List<AlcoholDrinkDto> alcoholDrinkDtos = new ArrayList<>();
        for (AlcoholDrink alcoholDrink : order.getAlcoholDrinks()) {
            alcoholDrinkDtos.add(alcoholDrinkMapper.objectToDto(alcoholDrink));
        }
        orderDto.setDrinks(alcoholDrinkDtos);
        return orderDto;
    }

    public Order dtoToObject(OrderDto orderDto) {
        Order order = new Order();
        List<AlcoholDrink> alcoholDrinks = new ArrayList<>();
        for (AlcoholDrinkDto alcoholDrinkDto : orderDto.getDrinks()) {
            alcoholDrinks.add(alcoholDrinkMapper.dtoToObject(alcoholDrinkDto, new AlcoholDrink()));
        }
        order.setAlcoholDrinks(alcoholDrinks);
        return order;
    }

}
