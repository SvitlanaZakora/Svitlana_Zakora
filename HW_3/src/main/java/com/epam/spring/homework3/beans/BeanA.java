package com.epam.spring.homework3.beans;

import com.epam.spring.homework3.interfaces.DisposableBean;
import com.epam.spring.homework3.interfaces.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanA implements InitializingBean, DisposableBean {

    private String name;
    private int value;

    public BeanA(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void dispose() {
        System.out.println("Method dispose() executed");
    }

    @Override
    public void initialize() {
        System.out.println("Method initialize() executed");
    }
}
