package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.mapper.UserMapper;
import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.security.CustomPrincipal;
import com.test.demo.alcomarket.service.IRoleService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private IRoleService iRoleService;
    private final UserMapper userMapper;

    @Autowired
    UserServiceImpl(IUserRepository IUserRepository, UserMapper userMapper, IRoleService iRoleService, PasswordEncoder passwordEncoder) {
        this.iUserRepository = IUserRepository;
        this.userMapper = userMapper;
        this.iRoleService = iRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : iUserRepository.findAll()) {
            user.setPassword("secret");
            userDtos.add(userMapper.objectToDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getOne(Integer id) {
        UserDto userDto = userMapper.objectToDto(iUserRepository.getOne(id));
        return userDto;
    }

    @Override
    public UserDto hidePassword(UserDto userDto) {
        userDto.setPassword("secret");
        return userDto;
    }

    @Override
    public void deleteById(Integer id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        List<Role> roles = new ArrayList<Role>();
        roles.add(iRoleService.getDefaultRole());
        user.setRoles(roles);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        iUserRepository.save(user);
    }

    @Override
    public User getCurrent() {
        Integer userId = ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return iUserRepository.getOne(userId);
    }

    @Override
    public User getByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

}
