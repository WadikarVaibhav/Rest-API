package com.cars.car_service.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.car_service.model.Vehicle;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class FileRepository {
	
	public static List<Vehicle> read() {
		List<Vehicle> vehicles = new ArrayList<>();
		try {
			vehicles = Arrays.asList(new Gson().fromJson(new BufferedReader(
					new FileReader("C:\\Users\\vaibh\\Desktop\\vehicles.json")), Vehicle[].class));
		} catch (JsonParseException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
	
	public static void write(Vehicle vehicle) {
		
	}
	
	public static void update(Vehicle vehicle) {
		
	}

	public static void delete(Vehicle vehicle) {
		
	}

}
