package com.test.demo.alcomarket.service.impl;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;
import com.test.demo.alcomarket.repository.IUserRepository;
import com.test.demo.alcomarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserRepository IUserRepository;

    @Autowired
    UserServiceImpl(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return IUserRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return IUserRepository.getOne(id);
    }

    @Override
    public User disable(User user, UserDto userDto) {
        user.setActive(userDto.isActive());
        IUserRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        IUserRepository.deleteById(id);
    }

}
