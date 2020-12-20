package com.test.demo.alcomarket.controller;

import com.test.demo.alcomarket.dto.AuthenticationRequestDto;
import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.security.JwtTokenProvider;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final IUserService userService;
    private final UserMapper userMapper;

    @Autowired
    UserController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, IUserService userService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.getByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
