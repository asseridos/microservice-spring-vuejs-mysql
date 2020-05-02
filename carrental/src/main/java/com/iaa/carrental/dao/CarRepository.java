package com.iaa.carrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import com.iaa.carrental.models.Car;

@RestResource
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("SELECT h FROM Car h WHERE h.id=?1 ")
    public Car getCarById(Long id);
}