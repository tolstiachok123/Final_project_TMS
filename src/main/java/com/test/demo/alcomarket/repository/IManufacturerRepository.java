package com.test.demo.alcomarket.repository;

import com.test.demo.alcomarket.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    @Query("from Manufacturer where name =:name")
    Manufacturer findByName(String name);

}
