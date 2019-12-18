package com.vehicle.vehicleservice.datatransform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.vehicleservice.dto.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileResource {

	public static List<Vehicle> read() {
		List<Vehicle> vehicles = new ArrayList<>();
		File file = new File(ClassLoader.getSystemClassLoader().getResource("vehicles.csv").getFile());
		try {
			FileReader fr =  new FileReader(file);
			BufferedReader readFile = new BufferedReader(fr);
			String line="";
			while ((line = readFile.readLine()) != null) {
				String[] entries = line.split(",");
				Vehicle vehicle = new Vehicle(Integer.parseInt(entries[0]), Integer.parseInt(entries[1]), entries[2], entries[3]);
				vehicles.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	public static void write(List<Vehicle> vehicles) {
		try {
			PrintWriter writer = new PrintWriter(new File(ClassLoader.getSystemClassLoader().getResource("vehicles.csv").getFile()));
			for (Vehicle vehicle: vehicles) {
				List<String> vehicleDetails = new ArrayList<>();
				vehicleDetails.add(vehicle.getId().toString());
				vehicleDetails.add(vehicle.getYear().toString());
				vehicleDetails.add(vehicle.getMake());
				vehicleDetails.add(vehicle.getModel());
				String collect = vehicleDetails.stream().collect(Collectors.joining(","));
				writer.write(collect);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void update(Vehicle vehicle) {

	}

	public static void delete(Vehicle vehicle) {

	}

}