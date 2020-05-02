/**
 * 
 */
package com.iaa.carrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iaa.carrental.models.Rent;

/**
 * @author asser
 *
 */
public interface RentRepository extends JpaRepository<Rent, Long> {

}
