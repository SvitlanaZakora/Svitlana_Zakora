package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanD {

    private String name;
    private int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void init(){
        System.out.println("Initialized D");
    }

    public void destroy(){
        System.out.println("Destroyed");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
