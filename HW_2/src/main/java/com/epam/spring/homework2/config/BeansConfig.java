package com.epam.spring.homework2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.epam.spring.homework2.beans")
@Import(OtherConfig.class)
public class BeansConfig {
}
