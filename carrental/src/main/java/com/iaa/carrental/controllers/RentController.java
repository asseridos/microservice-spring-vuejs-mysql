package com.iaa.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iaa.carrental.dao.RentRepository;
import com.iaa.carrental.models.Rent;

@RepositoryRestController
public class RentController {

	@Autowired
	DiscoveryClient discoveryClient;
	
    private final RentRepository repository;

    @Autowired
    public RentController(RentRepository repo) { 
        repository = repo;
    }

    
    @RequestMapping(method = RequestMethod.POST , value = "/rents")
    public @ResponseBody Rent save(@RequestBody Rent rent) {
    	return repository.save(rent);
    }

}