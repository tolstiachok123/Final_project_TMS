package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.ManufacturerDto;
import com.test.demo.alcomarket.model.Manufacturer;

import java.util.List;

public interface IManufacturerService {

  public List<ManufacturerDto> getAll();

  public Manufacturer getById(Integer id);

  public void update(Integer id, Manufacturer manufacturer);

  public void addNew(Manufacturer manufacturer);

  public void deleteById(Integer Id);

  public Manufacturer getByName(String name);

}
