package com.vehicle.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.vehicleservice.datatransform.VehicleDataTransform;
import com.vehicle.vehicleservice.dto.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDataTransform vehicleDataTransform;

	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = vehicleDataTransform.getVehicles();
		return vehicles;
	}

	public List<Vehicle> createVehicle(Vehicle vehicle) {
		return vehicleDataTransform.createVehicle(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {
		vehicleDataTransform.update(vehicle);
	}

	public Vehicle deleteVehicle(int id) {
		return vehicleDataTransform.deleteVehicle(id);
	}
}
