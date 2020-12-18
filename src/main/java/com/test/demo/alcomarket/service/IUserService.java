package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;

import java.util.List;

public interface IUserService {

    public List<UserDto> getAllUsers();

    public UserDto getOne(Integer id);

    public void deleteById(Integer id);

    public void add(User user);

    public User getCurrent();

    public User getByUsername(String username);

}
