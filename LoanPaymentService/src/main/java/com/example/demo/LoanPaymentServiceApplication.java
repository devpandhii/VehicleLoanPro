package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanPaymentServiceApplication.class, args);
		System.out.println("LoanPayment Service started...");
	}

}
