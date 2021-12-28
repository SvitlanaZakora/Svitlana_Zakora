package com.epam.spring.homework4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private int id;
    private String login;
    private String role;
    private String pass;
}
