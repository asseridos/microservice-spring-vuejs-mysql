package com.iaa.carwash.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.iaa.carwash.dao.WashRepository;

@RepositoryRestController
public class WashController {

	@Autowired
	DiscoveryClient discoveryClient;
	
    @Autowired
    public WashController(WashRepository repo) {
    }

    @GetMapping("/cars") 
    public String getCars() {
    	System.out.println("zegerrffzef");
    	List<ServiceInstance> instancesCar = discoveryClient.getInstances("carrental-service");
    	ServiceInstance test_ = instancesCar.get(0);
    	String hostname = test_.getHost();
    	int port = test_.getPort();
    	
    	RestTemplate restTemplate = new RestTemplate();
    	String car_service_url = "http://" + hostname + ":" + port +"/cars/";
    	ResponseEntity<String> response = restTemplate.getForEntity(car_service_url, String.class);
    	String s = response.getBody();
    	System.out.println("zegerr"+s);
    	return s; 
    }
}