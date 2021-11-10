package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class SecondConfig {

    @Bean
    public static CustomBean createCustomBean() {
        return new CustomBean();
    }

    @Bean
    public static MyBeanPostProcessor createMyBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    public BeanA createBeanA() {
        return new BeanA("BeanA_name", 0);
    }

    @Bean
    public BeanE createBeanE() {
        return new BeanE("BeanE_name", 0);
    }

    @Bean
    @Lazy
    public BeanF createBeanF() {
        System.out.println("Create bean F");
        return new BeanF("BeanF_name", 0);
    }

}
