package com.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Async
public class SpringBootSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringJpaApplication.class, args);
	}
}
