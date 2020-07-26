package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.model.Order;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.AlcoholDrinkRepository;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import com.test.demo.alcomarket.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlcoholDrinkServiceImpl implements IAlcoholDrinkService {

    private IUserRepository iUserRepository;
    private AlcoholDrinkRepository alcoholDrinkRepository;
    private IOrderService orderService;

    @Autowired
    AlcoholDrinkServiceImpl(AlcoholDrinkRepository alcoholDrinkRepository, IUserRepository iUserRepository, IOrderService orderService) {
        this.alcoholDrinkRepository = alcoholDrinkRepository;
        this.iUserRepository = iUserRepository;
        this.orderService = orderService;
    }

    @Override
    public List<AlcoholDrink> findAll() {
        return alcoholDrinkRepository.findAll();
    }

    @Override
    public AlcoholDrink findByName(String name) {
        return alcoholDrinkRepository.findByName(name);
    }

    @Override
    public AlcoholDrink findById(Integer id) {
        return alcoholDrinkRepository.getOne(id);
    }

    @Override
    public AlcoholDrink update(AlcoholDrink alcoholDrink, AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrink.setAdv(alcoholDrinkDto.getAdv());
        alcoholDrink.setCost(alcoholDrinkDto.getCost());
        alcoholDrink.setName(alcoholDrinkDto.getName());
        alcoholDrink.setPhotoPath(alcoholDrinkDto.getPhotoPath());
        alcoholDrink.setQuantity(alcoholDrinkDto.getQuantity());
        alcoholDrink.setType(alcoholDrinkDto.getType());
        alcoholDrinkRepository.saveAndFlush(alcoholDrink);
        return alcoholDrink;
    }

    @Override
    public AlcoholDrink addNew(AlcoholDrink alcoholDrink, AlcoholDrinkDto alcoholDrinkDto) {
        alcoholDrink.setAdv(alcoholDrinkDto.getAdv());
        alcoholDrink.setCost(alcoholDrinkDto.getCost());
        alcoholDrink.setName(alcoholDrinkDto.getName());
        alcoholDrink.setPhotoPath(alcoholDrinkDto.getPhotoPath());
        alcoholDrink.setQuantity(alcoholDrinkDto.getQuantity());
        alcoholDrink.setType(alcoholDrinkDto.getType());
        alcoholDrinkRepository.saveAndFlush(alcoholDrink);
        return alcoholDrink;
    }

    @Override
    public void deleteById(Integer id) {
        alcoholDrinkRepository.deleteById(id);
    }

    @Override
    public void addToBasket(Integer alcoholId, Integer userId) {
        User user = iUserRepository.findById(userId).get();
        Order order = orderService.getCurrentOrCreateOrder(user);
        AlcoholDrink alcoholDrink = alcoholDrinkRepository.getOne(alcoholId);
        order.getAlcoholDrinks().add(alcoholDrink);
        orderService.update(order);
    }

}
