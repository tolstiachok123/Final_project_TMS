package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private IUserService userService;

    @Autowired
    TestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public CustomPrincipal showThisUserInfo() {
        return (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @PostMapping(value = "/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.add(userDto);
    }
}
