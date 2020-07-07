package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.repository.RoleRepository;
import com.test.demo.alcomarket.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    private RoleRepository roleRepository;

    @Autowired
    RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
