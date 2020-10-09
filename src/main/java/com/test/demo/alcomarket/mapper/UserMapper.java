package com.test.demo.alcomarket.mapper;

import com.test.demo.alcomarket.dto.UserDto;
import com.test.demo.alcomarket.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public UserDto objectToDto(User user) {
        return Objects.isNull(user) ? null : mapper.map(user, UserDto.class);
    }

    public User dtoToObject(UserDto userDto) {
        return Objects.isNull(userDto) ? null : mapper.map(userDto, User.class);
    }

}
