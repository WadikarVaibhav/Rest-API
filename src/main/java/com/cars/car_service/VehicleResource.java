package com.cars.car_service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cars.car_service.model.Vehicle;
import com.cars.car_service.repository.VehicleRepository;

@Path("/vehicles")
public class VehicleResource {

	private VehicleRepository vehicleRepository = new VehicleRepository();

	/**
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllActivities() {
		return Response.ok().entity(vehicleRepository.getVehicles()).header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * @param vehicleId
	 * @return
	 */
	@GET
	@Path("{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActivity(@PathParam("vehicleId") int vehicleId) {
		return Response.ok().entity(vehicleRepository.getVehicle(vehicleId)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	/**
	 * @param formParams
	 * @return
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(Map<String, String> formParams) {
		System.out.println(vehicleRepository.getTotalCount());
		int year = Integer.parseInt(formParams.get("Year"));
		String make = formParams.get("Make");
		String model = formParams.get("Model");
		return Response.ok().entity(vehicleRepository.createVehicle(year, make, model))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}

	/**
	 * @param activity
	 * @return
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateActivity(Vehicle vehicle) {
		return Response.ok().entity(vehicleRepository.updateVehicle(vehicle)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}

	/**
	 * @param vehicleId
	 * @return
	 */
	@DELETE
	@Path("{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVehicle(@PathParam("vehicleId") int vehicleId) {
		return Response.ok().entity(vehicleRepository.deleteVehicle(vehicleId))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
}
