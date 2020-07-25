package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.security.CustomPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/user")
    public CustomPrincipal showThisUserInfo() {
        return (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
