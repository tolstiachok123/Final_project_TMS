package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @Autowired
    UserController(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/user")
    public UserDto showThisUserInfo() {
        return userService.getOne(((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @PostMapping(value = "/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.add(userMapper.dtoToObject(userDto));
    }
}
