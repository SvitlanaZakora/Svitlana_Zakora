package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanF {

    private String name;
    private int value;

    public BeanF(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
