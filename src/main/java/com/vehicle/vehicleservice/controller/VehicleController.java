package com.vehicle.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vehicle.vehicleservice.dto.ErrorModel;
import com.vehicle.vehicleservice.dto.Vehicle;
import com.vehicle.vehicleservice.service.VehicleService;

@RestController
@RequestMapping("/")
@JsonIgnoreProperties(ignoreUnknown = false)
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@CrossOrigin
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ResponseEntity getAll() {
		return ResponseEntity.ok().body(vehicleService.getAllVehicles());
	}

	@CrossOrigin
	@RequestMapping(value = "/vehicles", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody Vehicle vehicle) {
		if (vehicle == null || vehicle.getYear() < 1950 && vehicle.getYear() > 2050) {
			return new ResponseEntity(new ErrorModel("Invalid Year"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/vehicles", method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody Vehicle vehicle) {
		vehicleService.updateVehicle(vehicle);
		return ResponseEntity.ok().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/vehicles/{vehicleId}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable(name="vehicleId") int id) {
		Vehicle deletedVehicle = vehicleService.deleteVehicle(id);
		if (deletedVehicle == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(deletedVehicle);
	}

}
