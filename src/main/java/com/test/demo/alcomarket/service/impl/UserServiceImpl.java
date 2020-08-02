package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserRepository iUserRepository;
    private UserMapper userMapper;

    @Autowired
    UserServiceImpl(IUserRepository IUserRepository, UserMapper userMapper) {
        this.iUserRepository = IUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : iUserRepository.findAll()) {
            userDtos.add(userMapper.objectToDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getOne(Integer id) {
        return userMapper.objectToDto(iUserRepository.getOne(id));
    }

    @Override
    public void deleteById(Integer id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }

    public User getCurrent() {
        Integer userId = ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return iUserRepository.getOne(userId);
    }

}
