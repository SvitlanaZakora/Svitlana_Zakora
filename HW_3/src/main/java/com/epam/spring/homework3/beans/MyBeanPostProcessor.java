package com.epam.spring.homework3.beans;

import com.epam.spring.homework3.interfaces.MyValidator;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof MyValidator){
            ((MyValidator) bean).validate();
        }
        return bean;

    }
}
