package com.epam.spring.homework2.config;

import com.epam.spring.homework2.pet.PetConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.epam.spring.homework2.other")
@Import(PetConfig.class)
public class OtherConfig {
}
