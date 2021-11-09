package com.epam.spring.homework2.pet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class))
public class PetConfig {

    @Bean
    @Primary
    Cheetah createCheetah1(){
        return new Cheetah();
    }

    @Bean
    @Qualifier
    Cheetah createCheetah2(){
        return new Cheetah();
    }
}
