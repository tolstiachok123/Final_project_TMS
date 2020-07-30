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
    public AlcoholDrinkDto findById(Integer id) {
        return alcoholDrinkMapper.objectToDto(IAlcoholDrinkRepository.getOne(id));
    }

    @Override
    public void update(Integer id, AlcoholDrinkDto alcoholDrinkDto) {
        AlcoholDrink alcoholDrink = IAlcoholDrinkRepository.getOne(id);
        IAlcoholDrinkRepository.saveAndFlush(alcoholDrinkMapper.dtoToObject(alcoholDrinkDto, alcoholDrink));
    }

    @Override
    public void addNew(AlcoholDrinkDto alcoholDrinkDto) {
        AlcoholDrink alcoholDrink = alcoholDrinkMapper.dtoToObject(alcoholDrinkDto, new AlcoholDrink());
        IAlcoholDrinkRepository.saveAndFlush(alcoholDrink);
    }

    @Override
    public void deleteById(Integer id) {
        IAlcoholDrinkRepository.deleteById(id);
    }

    @Override
    public void addToBasket(Integer alcoholId) {
        Order order = orderMapper.dtoToObject(orderService.getCurrentOrCreateOrder());
        AlcoholDrink alcoholDrink = IAlcoholDrinkRepository.getOne(alcoholId);
        order.getAlcoholDrinks().add(alcoholDrink);
        orderService.update(order);
    }

}
