package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.AlcoholDrinkDto;
import com.test.demo.alcomarket.model.AlcoholDrink;
import com.test.demo.alcomarket.repository.AlcoholDrinkRepository;
import com.test.demo.alcomarket.service.IAlcoholDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlcoholDrinkServiceImpl implements IAlcoholDrinkService {

    private AlcoholDrinkRepository alcoholDrinkRepository;

    @Autowired
    AlcoholDrinkServiceImpl(AlcoholDrinkRepository alcoholDrinkRepository) {
        this.alcoholDrinkRepository = alcoholDrinkRepository;
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


}
