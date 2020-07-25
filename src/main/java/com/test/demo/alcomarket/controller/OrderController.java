package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private IOrderRepository orderRepository;

    @Autowired
    OrderController(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/order/{id}")
    public Order show(@PathVariable(name = "id") Integer id) {
        return orderRepository.getOne(id);
    }

    @DeleteMapping(value = "/order/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        orderRepository.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
