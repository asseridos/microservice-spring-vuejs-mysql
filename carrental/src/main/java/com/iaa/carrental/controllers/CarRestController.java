package com.iaa.carrental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaa.carrental.dao.CarRepository;
import com.iaa.carrental.models.Car;

@CrossOrigin
@RestController

public class CarRestController {
	private final CarRepository repository;

    @Autowired
    public CarRestController(CarRepository repo) { 
        repository = repo;
    }

    @RequestMapping(method =  RequestMethod.GET, value = "/car_ids") 
    public @ResponseBody List<Car> getCarIds() {
        return repository.findAll(); 
    }
}