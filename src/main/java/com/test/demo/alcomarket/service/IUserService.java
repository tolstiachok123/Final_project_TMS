package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllUsers();

    public User getOne(Integer id);

    public User disable(User user);

    public void deleteById(Integer id);

    public void add(UserDto userDto);

    public User getCurrent();
}
