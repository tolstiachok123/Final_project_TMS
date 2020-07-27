package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IOrderRepository;
import com.test.demo.alcomarket.service.IOrderService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;

    private IUserService userService;

    @Autowired
    OrderServiceImpl(IOrderRepository orderRepository, IUserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public Order getOne(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getCurrentOrCreateOrder() {
        User user = userService.getCurrent();
        try {
            return orderRepository.getCurrentOrder(user);
        } catch (Exception e) {
            Order order = new Order();
//            order.setUser(user);
            order.setStatus(true);
            order.setAlcoholDrinks(new ArrayList<>());
            return order;
        }
    }

    @Override
    public OrderDto getCurrentOrCreateOrderDto(){
        User user = userService.getCurrent();
        try {
            Order currentOrder = orderRepository.getCurrentOrder(user);
            OrderDto responseOrder = new OrderDto();
            List<AlcoholDrinkDto> alcoholDrinkDtos = new ArrayList<>();
            for (int i = 0; i < currentOrder.getAlcoholDrinks().size(); i++) {
                AlcoholDrinkDto alcoholDrinkDto = new AlcoholDrinkDto();
                AlcoholDrink alcoholDrink = currentOrder.getAlcoholDrinks().get(i);

                alcoholDrinkDto.setAdv(alcoholDrink.getAdv());
                alcoholDrinkDto.setCost(alcoholDrink.getCost());
                alcoholDrinkDto.setName(alcoholDrink.getName());
                alcoholDrinkDto.setType(alcoholDrink.getType());
                alcoholDrinkDto.setPhotoPath(alcoholDrink.getPhotoPath());

                alcoholDrinkDtos.add(alcoholDrinkDto);
            }
            responseOrder.setDrinks(alcoholDrinkDtos);
            return responseOrder;
        } catch (Exception e) {
            Order order = new Order();
//            order.setUser(user);
            order.setStatus(true);
            order.setAlcoholDrinks(new ArrayList<>());
            orderRepository.saveAndFlush(order);
            return new OrderDto();
        }
    }


    @Override
    public void update(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
