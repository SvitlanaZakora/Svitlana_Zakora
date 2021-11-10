package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.BeanB;
import com.epam.spring.homework3.beans.BeanC;
import com.epam.spring.homework3.beans.BeanD;
import com.epam.spring.homework3.beans.CustomBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@Import(SecondConfig.class)
@PropertySource("application.properties")
public class FirstConfig {
    @Value("${beanD.name}")
    private String nameD;
    @Value("${beanD.value}")
    private int valueD;

    @Value("${beanB.name}")
    private String nameB;
    @Value("${beanB.value}")
    private int valueB;

    @Value("${beanC.name}")
    private String nameC;
    @Value("${beanC.value}")
    private int valueC;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("createBeanD")
    public BeanB createBeanB(){
        return new BeanB(nameB, valueB);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("createBeanB")
    public BeanC createBeanC(){
        return new BeanC(nameC, valueC );
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD createBeanD(){
        return new BeanD(nameD, valueD);
    }
}
