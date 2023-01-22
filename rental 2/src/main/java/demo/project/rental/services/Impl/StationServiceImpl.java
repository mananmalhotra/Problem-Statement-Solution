package demo.project.rental.services.Impl;

import demo.project.rental.models.StationDetailsInfo;
import demo.project.rental.models.VehicleDetailsInfo;
import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.StationDetailsRequest;
import demo.project.rental.pojos.VehicleDetailsRequest;
import demo.project.rental.repositories.StationRepository;
import demo.project.rental.repositories.VehicleRepository;
import demo.project.rental.services.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    private final VehicleRepository vehicleRepository;

    @Autowired
    public StationServiceImpl(StationRepository stationRepository, VehicleRepository vehicleRepository){
        this.stationRepository = stationRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public GenericResponse createStation(String adminUUID, StationDetailsRequest stationDetailsRequest){
        StationDetailsInfo stationDetailsInfo = StationDetailsInfo.builder()
                .stationUUID(UUID.randomUUID().toString())
                .location(stationDetailsRequest.getLocation())
                .capacity(stationDetailsRequest.getCapacity())
                .build();

        stationRepository.save(stationDetailsInfo);
        return GenericResponse.builder()
                .stationUUID(stationDetailsInfo.stationUUID())
                .build();
    }

    @Override
    public List<VehicleDetailsRequest> getAllVehiclesByStation(String location){
        List<VehicleDetailsInfo> vehicleDetailsInfoList = vehicleRepository.findAllByLocation(location);
        List<VehicleDetailsRequest> vehicleDetailsRequestList = new ArrayList<>();
        for(VehicleDetailsInfo vehicleDetailsInfo : vehicleDetailsInfoList){
            vehicleDetailsRequestList.add(getVehicleDetailsRequestByInfo(vehicleDetailsInfo));
        }
        return vehicleDetailsRequestList;
    }

    public VehicleDetailsRequest getVehicleDetailsRequestByInfo(VehicleDetailsInfo vehicleDetailsInfo){
        return VehicleDetailsRequest.builder()
                .vehicleUUID(vehicleDetailsInfo.vehicleUUID())
                .vehicleNumber(vehicleDetailsInfo.vehicleNumber())
                .availability(vehicleDetailsInfo.availability())
                .atStation(vehicleDetailsInfo.atStation())
                .qrCode(vehicleDetailsInfo.qrCode())
                .createdAt(vehicleDetailsInfo.createdAt())
                .updatedAt(vehicleDetailsInfo.updatedAt())
                .build();
    }
}
