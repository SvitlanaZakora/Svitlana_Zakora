package com.epam.spring.homework2.pet;

import com.epam.spring.homework2.config.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ApplicationContext {

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        context.getBean(Pet.class).printPets();

        System.out.println(context.getBean("createCheetah1"));
        System.out.println(context.getBean(Cheetah.class));
    }
}
