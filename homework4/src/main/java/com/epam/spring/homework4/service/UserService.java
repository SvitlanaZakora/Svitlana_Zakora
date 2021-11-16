package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByLogin(String login);
    UserDto getUserById(int userId);
}
