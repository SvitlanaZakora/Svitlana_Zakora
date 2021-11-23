package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where login = ?", nativeQuery = true)
    User findByLogin(String login);
}
