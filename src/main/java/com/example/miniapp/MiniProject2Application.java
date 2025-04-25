package com.example.miniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.miniapp.repositories")
public class MiniProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(MiniProject2Application.class, args);
	}

}
