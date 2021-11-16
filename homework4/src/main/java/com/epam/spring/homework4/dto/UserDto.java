package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int id;
    private String login;
    private String role;
    private String pass;
}
