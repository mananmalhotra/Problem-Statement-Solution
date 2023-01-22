package demo.project.rental.services;

import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.StationDetailsRequest;
import demo.project.rental.pojos.VehicleDetailsRequest;

import java.util.List;

public interface StationService {

    public GenericResponse createStation(String adminUUID, StationDetailsRequest stationDetailsRequest);

    public List<VehicleDetailsRequest> getAllVehiclesByStation(String location);
}
