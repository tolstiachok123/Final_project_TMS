package com.test.demo.alcomarket.service;

import com.test.demo.alcomarket.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllUsers();

    public User getUserByUsername(String username);

}
