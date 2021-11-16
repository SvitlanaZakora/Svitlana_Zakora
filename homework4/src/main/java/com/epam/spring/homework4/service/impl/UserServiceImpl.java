package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserDto;
import com.epam.spring.homework4.service.UserService;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("create user with login {}",userDto.getLogin());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto getUserByLogin(String login) {
        log.info("get user by login {} ",login);
        User user = userRepository.getUserByLogin(login);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto getUserById(int userId) {
        log.info("get user by id {} ",userId);
        User user = userRepository.getUserById(userId);
        return mapUserToUserDto(user);
    }

    private UserDto mapUserToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .role(user.getRole())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .role(userDto.getRole())
                .pass(userDto.getPass())
                .build();
    }
}
