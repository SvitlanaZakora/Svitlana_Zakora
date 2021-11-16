package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;

public interface UserRepository {
    User createUser(User user);
    User getUserByLogin(String login);
    User getUserById(int userId);
}
