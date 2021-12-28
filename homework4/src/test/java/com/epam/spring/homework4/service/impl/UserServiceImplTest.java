package com.epam.spring.homework4.service.impl;
import com.epam.spring.homework4.dto.UserDto;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository repository;


    @Test
    public void insertTest() {
        User user = new User(1,"Petro", "123", "cashier");
        UserDto userDto = new UserDto(1,"Petro", "cashier", "123");
        when(repository.save(any())).thenReturn(user);

        userDto.setPass(null);
        UserDto result = userService.insert(userDto);
        assertEquals(userDto,result);
    }

    @Test
    public void findByLoginTest() {
        User user = new User(1,"Petro", "123", "cashier");
        UserDto userDto = new UserDto(1,"Petro", "cashier", "123");
        when(repository.findByLogin(any())).thenReturn(user);

        userDto.setPass(null);
        UserDto result = userService.findByLogin(userDto.getLogin());
        assertEquals(userDto,result);
    }

    @Test
    public void findByIdTest() {
        User user = new User(1,"Petro", "123", "cashier");
        UserDto userDto = new UserDto(1,"Petro", "cashier", "123");
        when(repository.findById(1)).thenReturn(user);

        userDto.setPass(null);
        UserDto result = userService.findById(userDto.getId());
        assertEquals(userDto,result);
    }
}