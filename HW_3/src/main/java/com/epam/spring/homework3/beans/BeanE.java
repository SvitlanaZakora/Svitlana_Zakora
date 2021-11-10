package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {

    private String name;
    private int value;

    public BeanE(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @PostConstruct
    void postConstruct() {
        System.out.println("Actions after bean E creation");
    }

    @PreDestroy
    void preDestroy() {
        System.out.println("Actions before destroying the bean E");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
