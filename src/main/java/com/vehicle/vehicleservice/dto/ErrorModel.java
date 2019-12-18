package com.vehicle.vehicleservice.dto;

public class ErrorModel {

	private String message;

	public ErrorModel(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
