package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private IOrderService orderService;

    @Autowired
    OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/current")
    public OrderDto getCurrent() {
        return orderService.getCurrentOrCreateOrderDto();
//
//        OrderDto orderDto = new OrderDto();
//
//        ArrayList<AlcoholDrinkDto> serializedDrinks = new ArrayList<>();
//
//        for (AlcoholDrink alcoholDrink : order.getAlcoholDrinks()) {
//            AlcoholDrinkDto serializedDrink = new AlcoholDrinkDto();
//            serializedDrink.setPhotoPath(alcoholDrink.getPhotoPath());
//            serializedDrink.setType(alcoholDrink.getType());
//            serializedDrink.setQuantity(alcoholDrink.getQuantity());
//            serializedDrink.setName(alcoholDrink.getName());
//            serializedDrink.setCost(alcoholDrink.getCost());
//            serializedDrink.setAdv(alcoholDrink.getAdv());
//
//            serializedDrinks.add(serializedDrink);
//        }
//
//        orderDto.setDrinks(serializedDrinks);
//
//        return orderDto;
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
