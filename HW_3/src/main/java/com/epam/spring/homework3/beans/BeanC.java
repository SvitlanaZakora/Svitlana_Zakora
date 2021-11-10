package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC {

    private String name;
    private int value;

    public BeanC(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void init(){
        System.out.println("Initialized C");
    }

    public void destroy(){
        System.out.println("Destroyed");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
