package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.mapper.OrderMapper;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IOrderRepository;
import com.test.demo.alcomarket.service.IOrderService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private OrderMapper orderMapper;
    private IUserService userService;
    private UserMapper userMapper;

    @Autowired
    OrderServiceImpl(IOrderRepository orderRepository, IUserService userService, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public OrderDto getOne(Integer id) {
        return orderMapper.objectToDto(orderRepository.getOne(id));
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto getCurrentOrCreateOrder() {
        User user = userMapper.dtoToObject(userService.getCurrent());
        try {
            return orderMapper.objectToDto(orderRepository.getCurrentOrder(user));
        } catch (Exception e) {
            Order order = new Order();
            order.setStatus(true);
            order.setAlcoholDrinks(new ArrayList<>());
            orderRepository.saveAndFlush(order);
            return orderMapper.objectToDto(order);
        }
    }

    @Override
    public void update(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
