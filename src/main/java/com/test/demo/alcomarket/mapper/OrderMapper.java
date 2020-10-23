package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private ModelMapper mapper;

    public OrderDto objectToDto(Order order) {
        return mapper.map(order, OrderDto.class);
    }

    public Order dtoToObject(OrderDto orderDto) {
        return mapper.map(orderDto, Order.class);
    }

}
