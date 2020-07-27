package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.Order;

public interface IOrderService {

    public OrderDto getOne(Integer id);

    public void deleteById(Integer id);

    public OrderDto getCurrentOrCreateOrder();

    public void update(Order order);

}
