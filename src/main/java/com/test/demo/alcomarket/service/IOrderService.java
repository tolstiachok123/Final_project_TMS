package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;

import java.util.List;

public interface IOrderService {

    public Order getOne(Integer id);

    public void deleteById(Integer id);

    public List<Order> getAll();

    public Order getCurrentOrCreateOrder(User user);

    public void update(Order order);

}
