package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.Order;

import java.util.List;

public interface IOrderService {

    public Order getOne(Integer id);

    public void deleteById(Integer id);

    public List<Order> getAll();

    public Order getCurrentOrCreateOrder();

    public  OrderDto getCurrentOrCreateOrderDto();

    public void update(Order order);

}
