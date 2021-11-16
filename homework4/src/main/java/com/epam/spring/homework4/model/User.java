package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private int id;
    private String login;
    private String pass;
    private String role;

}
