package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStatusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStatusServiceApplication.class, args);
		System.out.println("Application Status Service started ...");
	}

}
