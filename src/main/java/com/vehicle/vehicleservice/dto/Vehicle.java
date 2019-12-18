package com.vehicle.vehicleservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("Year")
	private Integer year;

	@JsonProperty("Make")
	private String make;

	@JsonProperty("Model")
	private String model;

	public Vehicle() {

	}

	public Vehicle(Integer id, Integer year, String make, String model) {
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public void setId(int id) {
		this.id = id;
	}
}
