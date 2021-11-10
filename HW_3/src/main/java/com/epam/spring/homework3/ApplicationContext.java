package com.epam.spring.homework3;

import com.epam.spring.homework3.beans.*;
import com.epam.spring.homework3.config.FirstConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContext {

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfig.class);
        BeanA beanA = context.getBean(BeanA.class);
        BeanB beanB = context.getBean(BeanB.class);
        BeanC beanC = context.getBean(BeanC.class);
        BeanD beanD = context.getBean(BeanD.class);
        BeanE beanE = context.getBean(BeanE.class);
        CustomBean customBean = context.getBean(CustomBean.class);
        MyBeanPostProcessor myBeanPostProcessor = context.getBean(MyBeanPostProcessor.class);

        System.out.println(beanA);
        System.out.println(beanB);
        System.out.println(beanC);
        System.out.println(beanD);
        System.out.println(beanE);
        System.out.println(customBean.getClass().getSimpleName());
        System.out.println(myBeanPostProcessor.getClass().getSimpleName());

        BeanF beanF = context.getBean(BeanF.class);
        System.out.println(beanF);
    }
}
