package com.iaa.carwash;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.iaa.carwash.models.Wash;

@SpringBootApplication
@EnableAutoConfiguration
public class CarwashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarwashApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start (RepositoryRestConfiguration rrc){
		return args -> {
			rrc.exposeIdsFor(Wash.class);
		} ;
	}

}