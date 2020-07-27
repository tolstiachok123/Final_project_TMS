package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    private IUserService userService;

    @Autowired
    TestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public UserDto showThisUserInfo() {
        UserDto userDto = new UserDto();
        User user = userService.getOne(((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        userDto.setUsername(user.getUsername());
        ArrayList<String> serializedRoles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            serializedRoles.add(role.getName().toString());
        }
        userDto.setRoles(serializedRoles);
        return userDto;
    }

    @PostMapping(value = "/registration")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.add(userDto);
    }
}
