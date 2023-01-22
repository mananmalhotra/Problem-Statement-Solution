package demo.project.rental.services.Impl;

import demo.project.rental.models.VehicleDetailsInfo;
import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.VehicleDetailsRequest;
import demo.project.rental.repositories.VehicleRepository;
import demo.project.rental.services.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public GenericResponse createVehicle(String adminUUID, VehicleDetailsRequest vehicleDetailsRequest){
        VehicleDetailsInfo vehicleDetailsInfo = VehicleDetailsInfo.builder()
                .vehicleUUID(UUID.randomUUID().toString())
                .vehicleNumber(vehicleDetailsRequest.getVehicleNumber())
                .availability(vehicleDetailsRequest.getAvailability())
                .atStation(vehicleDetailsRequest.getAtStation())
                .qrCode(vehicleDetailsRequest.getQrCode())
                .build();
        vehicleRepository.save(vehicleDetailsInfo);
        return GenericResponse.builder()
                .vehicleUUID(vehicleDetailsInfo.vehicleUUID())
                .build();
    }
}
