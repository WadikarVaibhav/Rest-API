package com.vehicle.vehicleservice.datatransform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

import com.vehicle.vehicleservice.dto.Vehicle;

@Component
public class VehicleDataTransform {

	List<Vehicle> vehicles = new ArrayList<>();

	public List<Vehicle> getVehicles() {
		vehicles = FileResource.read();
		return vehicles;
	}

	public List<Vehicle> createVehicle(Vehicle vehicle) {
		vehicle.setId(generateId());
		vehicles.add(vehicle);
		FileResource.write(vehicles);
		return getVehicles();
	}

	private int generateId() {
		Collections.sort(vehicles, new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				return o1.getId() - o2.getId();
			}
		});
		return vehicles.size() == 0 ? 1 : vehicles.get(vehicles.size()-1).getId()+1;
	}

	public void update(Vehicle vehicle) {
		for (Vehicle veh: vehicles) {
			if (veh.getId() == vehicle.getId()) {
				veh.setYear(vehicle.getYear());
				veh.setMake(vehicle.getMake());
				veh.setModel(vehicle.getModel());
				return;
			}
		}
		return;
	}

	public Vehicle deleteVehicle(int id) {
		for (Vehicle veh: vehicles) {
			if (veh.getId() == id) {
				vehicles.remove(veh);
				return veh;
			}
		}
		return null;
	}
}