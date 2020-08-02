package com.test.demo.alcomarket.service.impl;

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

    private final IOrderRepository orderRepository;
    private OrderMapper orderMapper;
    private final IUserService userService;
    private UserMapper userMapper;

    @Autowired
    OrderServiceImpl(IOrderRepository orderRepository, IUserService userService, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
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
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void payCurrentOrder() {
        Order currentOrder = orderRepository.getCurrentOrder(userService.getCurrent());
        currentOrder.setStatus(false);
        orderRepository.save(currentOrder);
    }


}
