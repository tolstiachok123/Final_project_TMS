package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.AlcoholDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAlcoholDrinkRepository extends JpaRepository<AlcoholDrink, Integer> {

    @Query("from AlcoholDrink where name =:name")
    AlcoholDrink findByName(String name);
//
//    @Query("INSERT INTO ")
//    void save(AlcoholDrink alcoholDrink);
}
