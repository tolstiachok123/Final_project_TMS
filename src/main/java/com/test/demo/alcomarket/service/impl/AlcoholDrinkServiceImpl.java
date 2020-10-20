package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.mapper.AlcoholDrinkMapper;
import com.test.demo.alcomarket.mapper.OrderMapper;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.repository.IAlcoholDrinkRepository;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlcoholDrinkServiceImpl implements IAlcoholDrinkService {

    private IAlcoholDrinkRepository IAlcoholDrinkRepository;
    private IOrderService orderService;
    private AlcoholDrinkMapper alcoholDrinkMapper;
    private OrderMapper orderMapper;

    @Autowired
    AlcoholDrinkServiceImpl(IAlcoholDrinkRepository IAlcoholDrinkRepository, IOrderService orderService, AlcoholDrinkMapper alcoholDrinkMapper, OrderMapper orderMapper) {
        this.IAlcoholDrinkRepository = IAlcoholDrinkRepository;
        this.orderService = orderService;
        this.alcoholDrinkMapper = alcoholDrinkMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<AlcoholDrinkDto> findAll() {
        List<AlcoholDrink> drinks = IAlcoholDrinkRepository.findAll();
        List<AlcoholDrinkDto> drinkDtos = new ArrayList<AlcoholDrinkDto>();
        for (AlcoholDrink drink : drinks) {
            drinkDtos.add(alcoholDrinkMapper.objectToDto(drink));
        }
        return drinkDtos;
    }

    @Override
    public AlcoholDrink findById(Integer id) {
        return IAlcoholDrinkRepository.getOne(id);
    }

    @Override
    public void update(Integer id, AlcoholDrink alcoholDrink) {
        AlcoholDrink oldAlcoholDrink = IAlcoholDrinkRepository.getOne(id);
        alcoholDrink.setId(oldAlcoholDrink.getId());
        IAlcoholDrinkRepository.saveAndFlush(alcoholDrink);
    }

    @Override
    public void addNew(AlcoholDrink alcoholDrink) {
        IAlcoholDrinkRepository.saveAndFlush(alcoholDrink);
    }

    @Override
    public void deleteById(Integer id) {
        IAlcoholDrinkRepository.deleteById(id);
    }

    @Override
    public void addToBasket(Integer alcoholId) {
        Order order = orderService.getCurrentOrCreateOrder();
        AlcoholDrink alcoholDrink = IAlcoholDrinkRepository.getOne(alcoholId);
        alcoholDrink.getOrders().add(order);
//        order.getAlcoholDrinks().add(alcoholDrink);
        orderService.update(order);
    }

}
