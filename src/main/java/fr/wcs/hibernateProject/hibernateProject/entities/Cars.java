package fr.wcs.hibernateProject.hibernateProject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {
	
	public Cars() {
	}
	
	public Cars(String brand, String color, int kilometers) {
		this.brand = brand;
		this.color = color;
		this.kilometers = kilometers;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String color;
	private int kilometers;
	
	@Override
	public String toString() {
		return "The brand is : " + brand + 
				", his color is : " + color + 
				" and his kilometers is : " + kilometers;
	}
	
	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}
	
}
