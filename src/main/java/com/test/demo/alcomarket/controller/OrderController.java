package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.mapper.OrderMapper;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private final IOrderService orderService;
    private final OrderMapper orderMapper;
    private final AlcoholDrinkMapper alcoholDrinkMapper;

    @Autowired
    OrderController(IOrderService orderService, OrderMapper orderMapper, AlcoholDrinkMapper alcoholDrinkMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.alcoholDrinkMapper = alcoholDrinkMapper;
    }

    @GetMapping(value = "/order/current")
    public OrderDto getCurrent() {
        return orderMapper.objectToDto(orderService.getCurrentOrCreateOrder());
    }

    @GetMapping(value = "/order/{id}")
    public OrderDto show(@PathVariable(name = "id") Integer id) {
        Order order = orderService.getOne(id);
        OrderDto orderDto = orderMapper.objectToDto(order);
        List<AlcoholDrinkDto> drinkDtos = new ArrayList<>();
        for (AlcoholDrink alcoholDrink : order.getAlcoholDrinks()) {
            drinkDtos.add(alcoholDrinkMapper.objectToDto(alcoholDrink));
        }
        orderDto.setDrinks(drinkDtos);
        return orderDto;
    }

    @PostMapping(value = "/order/current/pay")
    public void payForOrder() {
        orderService.payCurrentOrder();
    }

}
