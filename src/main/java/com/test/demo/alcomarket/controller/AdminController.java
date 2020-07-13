package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/admin")
public class AdminController {

    private IUserService userService;

    @Autowired
    AdminController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> showAll() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User showById(@PathVariable(name = "id") Integer id) {
        return userService.getOne(id);
    }

    @PutMapping(value = "/users/{id}")
    public User disableById(@PathVariable(name = "id") Integer id,
                                @RequestBody UserDto userDto) {
        User user = userService.getOne(id);
        return userService.disable(user, userDto);
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteById(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
        return "User deleted successfully!";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }
}
