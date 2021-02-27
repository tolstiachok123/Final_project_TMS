package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.mapper.OrderMapper;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    OrderController(IOrderService orderService, OrderMapper orderMapper, AlcoholDrinkMapper alcoholDrinkMapper) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/current")
    public OrderDto getCurrent() {
        Order order = orderService.getCurrentOrCreateOrder();
        return orderService.getOrderDto(order);
    }

    @GetMapping(value = "/order/{id}")
    public OrderDto show(@PathVariable(name = "id") Integer id) {
        Order order = orderService.getOne(id);
        return orderService.getOrderDto(order);
    }

    @GetMapping(value = "/order/current/pay")
    public void payForOrder() {
        orderService.payCurrentOrder();
    }

}
