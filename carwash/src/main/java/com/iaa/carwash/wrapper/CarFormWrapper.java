/**
 * 
 */
package com.iaa.carwash.wrapper;

/**
 * @author asser
 *
 */

public class CarFormWrapper {
    private String brand;
    private String model;
    private String plateNumber;
    private String price;
	private String description;

    public CarFormWrapper(String brand, String model, String plateNumber,
		String price, String description) {
		super();
		this.brand = brand;
		this.model = model;
		this.plateNumber = plateNumber;
		this.price = price;
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String desc) {
		this.description = desc;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}