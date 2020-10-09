package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.OrderDto;
import com.test.demo.alcomarket.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderMapper {

    @Autowired
    private ModelMapper mapper;

    public OrderDto objectToDto(Order order) {
        return Objects.isNull(order) ? null : mapper.map(order, OrderDto.class);
    }

    public Order dtoToObject(OrderDto orderDto) {
        return Objects.isNull(orderDto) ? null : mapper.map(orderDto, Order.class);
    }

}
