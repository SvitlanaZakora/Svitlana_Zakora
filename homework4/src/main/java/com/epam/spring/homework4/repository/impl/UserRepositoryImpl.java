package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        return list.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found"));
    }

    @Override
    public User getUserById(int userId) {
        return list.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found"));
    }
}
