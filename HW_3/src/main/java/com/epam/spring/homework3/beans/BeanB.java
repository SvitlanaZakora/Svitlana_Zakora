package com.epam.spring.homework3.beans;

import com.epam.spring.homework3.interfaces.MyValidator;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements MyValidator {

    private String name;
    private int value;

    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void validate() {
        if (this.name != null && this.value >= 0){
            System.out.println("Bean B validated successfully");
            return;
        }
        System.out.println("Bean B validation failed");
    }

    public void init(){
        System.out.println("Initialized B");
    }

    public void changedInit(){
        System.out.println("Initialized B (changed)");
    }

    public void destroy(){
        System.out.println("Destroyed");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


}
