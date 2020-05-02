package com.iaa.carrental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.iaa.carrental.models.Car;

@SpringBootApplication
@EnableAutoConfiguration
public class CarrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrentalApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start (RepositoryRestConfiguration rrc){
		return args -> {
			rrc.exposeIdsFor(Car.class);
		} ;
	}

}