package com.epam.spring.homework4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.epam.spring.homework4.repository")
public class Homework4Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework4Application.class, args);
	}

}
