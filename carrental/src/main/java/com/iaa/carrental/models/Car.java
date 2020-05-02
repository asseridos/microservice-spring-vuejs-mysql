/**
 * 
 */
package com.iaa.carrental.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author asser
 *
 */

@Entity
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
	private String brand;
    private String model;
    private String plateNumber;
    private double price;
	private String description;
	

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}


    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Car(Long id, String brand, String model, String color, String plateNumber, double price,
			String picture , String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.plateNumber = plateNumber;
		this.price = price;
		this.description = description;
	}
	
	public Car() {
		
	}

	public Car(Long id) {
		
	}
}