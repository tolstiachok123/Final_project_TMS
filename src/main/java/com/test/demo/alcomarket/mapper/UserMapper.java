package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    private IRoleService roleService;

    @Autowired
    UserMapper(IRoleService roleService) {
        this.roleService = roleService;
    }

    public UserDto objectToDto(User user) {

        UserDto userDto = new UserDto();

        List<String> rolesStringFormat = new ArrayList<>();
        for (Role role : user.getRoles()) {
            rolesStringFormat.add(role.getName().toString());
        }

        userDto.setUsername(user.getUsername());
        userDto.setRoles(rolesStringFormat);
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User dtoToObject(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setEmail(userDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setUsername(userDto.getUsername());
        user.setRoles(getDefaultRoleList());
        user.setPhone(userDto.getPhone());
        return user;
    }

    private List<Role> getDefaultRoleList() {
        List<Role> defaultRoleList = new ArrayList<Role>();
        defaultRoleList.add(roleService.getDefaultRole());
        return defaultRoleList;
    }

}
