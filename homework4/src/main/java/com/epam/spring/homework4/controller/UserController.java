package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.UserDto;
import com.epam.spring.homework4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController{

    @Autowired
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        validateUser(userDto);
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/login/{login}")
    public UserDto getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    private void validateUser(UserDto userDto){
        String role = userDto.getRole();
        if (!role.equals("CASHIER") && !role.equals("SENIOR_CASHIER") && !role.equals("COMMODITY_EXPERT")){
            throw new RuntimeException("Role" + role + " is not validated");
        }
    }

}
