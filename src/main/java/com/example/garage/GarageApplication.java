package com.example.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class GarageApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GarageApplication.class, args);
		
	}

}
