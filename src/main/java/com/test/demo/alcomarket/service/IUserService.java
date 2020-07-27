package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.UserDto;

import java.util.List;

public interface IUserService {

    public List<UserDto> getAllUsers();

    public UserDto getOne(Integer id);

    public void deleteById(Integer id);

    public void add(UserDto userDto);

    public UserDto getCurrent();
}
