/**
 * 
 */
package com.iaa.carwash.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author asser
 *
 */

@Entity
public class Wash {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
	private String washType;
    private double price;
    private String status;
    private String carId;

    /**
	 * @return the washType
	 */
	public String getWashType() {
		return washType;
	}
	/**
	 * @param washType the washType to set
	 */
	public void setWashType(String washType) {
		this.washType = washType;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
		/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
}
