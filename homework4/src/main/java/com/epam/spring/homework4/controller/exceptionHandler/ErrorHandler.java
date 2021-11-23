package com.epam.spring.homework4.controller.exceptionHandler;


import com.epam.spring.homework4.exceptions.DublicateEntryException;
import com.epam.spring.homework4.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler{

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String handleNotFoundException(RuntimeException ex, WebRequest request) {
        return ex.getMessage();
    }

    @ExceptionHandler(DublicateEntryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected String handleSException(RuntimeException ex, WebRequest request) {
        return ex.getMessage();
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleException(Exception ex) {
//        return "Internal error occurred";
//    }
}
