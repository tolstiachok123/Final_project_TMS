package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.model.Order;

public interface IOrderService {

    public Order getOne(Integer id);

    public void deleteById(Integer id);

    public Order getCurrentOrCreateOrder();

    public void update(Order order);

    public void payCurrentOrder();
}
