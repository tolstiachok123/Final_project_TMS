package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.UserRepository;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User disable(User user, UserDto userDto) {
        user.setActive(userDto.isActive());
        userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
