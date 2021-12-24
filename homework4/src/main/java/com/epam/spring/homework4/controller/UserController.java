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
    public UserDto insert(@RequestBody UserDto userDto) {
        validateUser(userDto);
        return userService.insert(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/login/{login}")
    public UserDto findByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{userId}")
    public UserDto findById(@PathVariable int userId) {
        return userService.findById(userId);
    }

    private void validateUser(UserDto userDto){
        String role = userDto.getRole();
        if (!role.equals("CASHIER") && !role.equals("SENIOR_CASHIER") && !role.equals("COMMODITY_EXPERT")){
            throw new RuntimeException("Role" + role + " is not validated");
        }
    }

}
