package com.tsfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Moonlit system server 
//Company , Department , Employee , Payment Service  

@SpringBootApplication // in spring core : Configuration + Component scan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
