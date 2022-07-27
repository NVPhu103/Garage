package com.example.garage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.garage.entity.CarService;
import com.example.garage.entity.RepairedCar;
import com.example.garage.service.CarSerService;
import com.example.garage.service.RepairedCarService;


@SpringBootApplication
@ComponentScan("com.example")
public class GarageApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GarageApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner run(CarSerService carSerService, RepairedCarService repairedCarService) {
		return args ->{
			CarService carService1 = carSerService.addService(new CarService("rua xe", 100000, "rua xe nude"));
			RepairedCar repairedCar1 = repairedCarService.addRepairedCar( new RepairedCar(LocalDateTime.now(), "test", "test", "test", "test") );
			
			//                      v.addServiceToCar(2L, carService1.getSerNumber());
			repairedCarService.addServiceToCar(2L, carService1.getSerNumber());
		};
	}

}
