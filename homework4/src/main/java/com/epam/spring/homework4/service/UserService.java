package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto insert(UserDto userDto);
    UserDto findByLogin(String login);
    UserDto findById(int userId);
}
