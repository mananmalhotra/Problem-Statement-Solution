package demo.project.rental.services;

import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.VehicleDetailsRequest;

public interface VehicleService {

    public GenericResponse createVehicle(String adminUUID, VehicleDetailsRequest vehicleDetailsRequest);
}
