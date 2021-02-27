package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.mapper.OrderMapper;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IOrderRepository;
import com.test.demo.alcomarket.service.IOrderService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private OrderMapper orderMapper;
    private final IUserService userService;
    private UserMapper userMapper;
    private final AlcoholDrinkMapper alcoholDrinkMapper;
    private final EntityManager entityManager;

    @Autowired
    OrderServiceImpl(IOrderRepository orderRepository, IUserService userService, OrderMapper orderMapper, UserMapper userMapper, EntityManager entityManager, AlcoholDrinkMapper alcoholDrinkMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
        this.entityManager = entityManager;
        this.alcoholDrinkMapper = alcoholDrinkMapper;
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
    public Order getCurrentOrCreateOrder() {
        User user = userService.getCurrent();
        Order activeOrder = orderRepository.getCurrentOrder(user);
        if (activeOrder != null) {
            return activeOrder;
        } else {
            Order order = new Order();
            order.setStatus(true);
            order.setAlcoholDrinks(new ArrayList<>());
            order.setUser(user);
            orderRepository.save(order);
            return order;
        }
    }

    @Override
    public OrderDto getOrderDto(Order order) {
        OrderDto orderDto = orderMapper.objectToDto(order);
        List<AlcoholDrinkDto> drinkDtos = new ArrayList<>();
        for (AlcoholDrink alcoholDrink : order.getAlcoholDrinks()) {
            drinkDtos.add(alcoholDrinkMapper.objectToDto(alcoholDrink));
        }
        orderDto.setDrinks(drinkDtos);
        return orderDto;
    }

    @Override
    public void update(Order order) {
        entityManager.persist(order);
        orderRepository.saveAndFlush(order);
        orderRepository.flush();
        entityManager.flush();
    }

    @Override
    public void payCurrentOrder() {
        Order currentOrder = orderRepository.getCurrentOrder(userService.getCurrent());
        currentOrder.setStatus(false);
        orderRepository.save(currentOrder);
    }


}
