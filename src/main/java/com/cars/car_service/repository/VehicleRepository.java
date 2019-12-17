package com.cars.car_service.repository;

import java.util.ArrayList;
import java.util.List;

import com.cars.car_service.model.Vehicle;

public class VehicleRepository {
	
	private List<Vehicle> vehicles;
	
	public VehicleRepository() {
		vehicles = new ArrayList<>();
	}
	
	/**
	 * @return
	 */
	public List<Vehicle> getVehicles() {
		vehicles = FileRepository.read();
		return vehicles;
	}
	
	/**
	 * @return
	 */
	public int getTotalCount() {
		return vehicles.size();
	}
	
	/**
	 * @param vehicleId
	 * @return
	 */
	public Vehicle getVehicle(int vehicleId) {
		for (Vehicle vehicle: vehicles) {
			if (vehicle.getId() == vehicleId)	return vehicle;
		}
		return null;
	}

	/**
	 * @param vehicle
	 * @return
	 */
	public List<Vehicle> createVehicle(int year, String model, String make) {
		int id = generateId();
		Vehicle vehicle = new Vehicle(id, year, make, model);
		vehicles.add(vehicle);
		FileRepository.write(vehicle);
		return vehicles;
	}

	/**
	 * @param vehicleToUpdate
	 * @return
	 */
	public List<Vehicle> updateVehicle(Vehicle vehicleToUpdate) {
		for (Vehicle vehicle: vehicles) {
			if (vehicle.getId() == vehicleToUpdate.getId()) {
				vehicle.setYear(vehicleToUpdate.getYear());
				vehicle.setModel(vehicleToUpdate.getModel());
				vehicle.setMake(vehicleToUpdate.getMake());
				FileRepository.update(vehicleToUpdate);
				break;
			}
		}
		return vehicles;
	}

	/**
	 * @param vehicleId
	 * @return
	 */
	public List<Vehicle> deleteVehicle(int vehicleId) {
		for (Vehicle vehicle: vehicles) {
			if (vehicle.getId() == vehicleId) {
				vehicles.remove(vehicle);
				FileRepository.delete(vehicle);
				break;
			}
		}
		return vehicles;
	}
	
	private int generateId() {
		return (vehicles.size() == 0) ? 1 : vehicles.get(vehicles.size()-1).getId()+1;
	}
}
