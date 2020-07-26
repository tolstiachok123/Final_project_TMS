package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private IOrderService orderService;

    @Autowired
    OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/current")
    public Order getCurrent() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.getCurrentOrCreateOrder(user);
    }

    @GetMapping(value = "/order/{id}")
    public Order show(@PathVariable(name = "id") Integer id) {
        return orderService.getOne(id);
    }

    @DeleteMapping(value = "/order/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        orderService.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
