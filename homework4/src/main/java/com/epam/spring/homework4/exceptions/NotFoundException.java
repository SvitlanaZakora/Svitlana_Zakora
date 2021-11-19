package com.epam.spring.homework4.exceptions;


public class NotFoundException extends RuntimeException{

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
