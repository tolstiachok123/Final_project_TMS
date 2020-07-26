package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.service.IRoleService;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserRepository iUserRepository;
    private IRoleService roleService;

    @Autowired
    UserServiceImpl(IUserRepository IUserRepository, IRoleService roleService) {
        this.iUserRepository = IUserRepository;
        this.roleService = roleService;
    }

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return iUserRepository.getOne(id);
    }

    @Override
    public User disable(User user) {
        user.setActive(false);
        iUserRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public void add(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setEmail(userDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setUsername(userDto.getUsername());
        user.setRoles(getDefaultRoleList());
        iUserRepository.saveAndFlush(user);
    }

    private List<Role> getDefaultRoleList() {
        List<Role> defaultRoleList = new ArrayList<Role>();
        defaultRoleList.add(roleService.getDefaultRole());
        return defaultRoleList;
    }

}
