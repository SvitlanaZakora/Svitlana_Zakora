package com.epam.spring.homework2.pet;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Cheetah implements Animal{
    @Override
    public String getAnimal() {
        return "Cheetah";
    }
}
