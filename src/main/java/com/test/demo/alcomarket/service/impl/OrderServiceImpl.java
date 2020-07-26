package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IOrderRepository;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;

    @Autowired
    OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
    public Order getCurrentOrCreateOrder(User user) {
        for (Order order : user.getOrders()) {
            if (order.isStatus()) return orderRepository.findById(order.getId()).get();
        }
        return new Order();
    }

    @Override
    public void update(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
