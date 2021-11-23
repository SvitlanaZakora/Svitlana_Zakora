package com.epam.spring.homework4.exceptions;

public class DublicateEntryException extends RuntimeException{

    public DublicateEntryException(String errorMessage) {
        super(errorMessage);
    }
}
