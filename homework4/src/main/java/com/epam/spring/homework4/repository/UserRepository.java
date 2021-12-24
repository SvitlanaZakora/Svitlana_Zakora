package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    User findByLogin(String login);
    User findById(int userId);
}
