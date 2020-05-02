/**
 * 
 */
package com.iaa.carwash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iaa.carwash.models.Wash;

/**
 * @author asser
 *
 */
public interface WashRepository extends JpaRepository<Wash, Long> {

}
