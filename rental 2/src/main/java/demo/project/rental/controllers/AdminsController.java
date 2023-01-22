package demo.project.rental.controllers;

import demo.project.rental.pojos.BaseResponse;
import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.StationDetailsRequest;
import demo.project.rental.pojos.VehicleDetailsRequest;
import demo.project.rental.services.StationService;
import demo.project.rental.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminsController {

    private final StationService stationService;

    private final VehicleService vehicleService;

    @Autowired
    public AdminsController(StationService stationService, VehicleService vehicleService) {
        this.stationService = stationService;
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add-vehicle")
    public ResponseEntity<BaseResponse<GenericResponse>> addVehicleDetails(
            @RequestHeader String adminUUID,
            @Valid @RequestBody VehicleDetailsRequest vehicleDetailsRequest) {
        return new ResponseEntity<>(new BaseResponse<>("success", vehicleService.createVehicle(adminUUID, vehicleDetailsRequest)), HttpStatus.CREATED);
    }

    @PostMapping("/add-station")
    public ResponseEntity<BaseResponse<GenericResponse>> addStationDetails(
            @RequestHeader String adminUUID,
            @Valid @RequestBody StationDetailsRequest stationDetailsRequest) {
        return new ResponseEntity<>(new BaseResponse<>("success", stationService.createStation(adminUUID, stationDetailsRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/station/vehicles")
    public ResponseEntity<BaseResponse<List<VehicleDetailsRequest>>> getAllVehiclesByStation(
            @RequestHeader String location) {
        return new ResponseEntity<>(new BaseResponse<>("success", stationService.getAllVehiclesByStation(location)), HttpStatus.OK);
    }

}