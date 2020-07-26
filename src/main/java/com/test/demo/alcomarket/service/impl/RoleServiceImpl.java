package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.model.Role;
import com.test.demo.alcomarket.repository.IRoleRepository;
import com.test.demo.alcomarket.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    private IRoleRepository IRoleRepository;

    @Autowired
    RoleServiceImpl(IRoleRepository IRoleRepository) {
        this.IRoleRepository = IRoleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return IRoleRepository.findAll();
    }

    @Override
    public Role getDefaultRole() {
        return IRoleRepository.findByName();
    }
}
