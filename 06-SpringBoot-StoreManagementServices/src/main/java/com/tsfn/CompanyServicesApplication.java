package com.tsfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class CompanyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServicesApplication.class, args);
		System.out.println("RAYAN");
	}

}