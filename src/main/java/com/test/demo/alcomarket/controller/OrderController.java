package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private IOrderService orderService;

    @Autowired
    OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/current")
    public OrderDto getCurrent() {
        return orderService.getCurrentOrCreateOrder();
    }

    @GetMapping(value = "/order/{id}")
    public OrderDto show(@PathVariable(name = "id") Integer id) {
        return orderService.getOne(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
