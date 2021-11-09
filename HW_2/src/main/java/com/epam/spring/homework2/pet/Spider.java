package com.epam.spring.homework2.pet;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class Spider implements Animal{
    @Override
    public String getAnimal() {
        return "Spider";
    }
}
