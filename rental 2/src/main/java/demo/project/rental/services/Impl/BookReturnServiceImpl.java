package demo.project.rental.services.Impl;

import com.google.zxing.WriterException;
import demo.project.rental.models.VehicleDetailsInfo;
import demo.project.rental.pojos.BookReturnRequest;
import demo.project.rental.repositories.StationRepository;
import demo.project.rental.repositories.VehicleRepository;
import demo.project.rental.services.BookReturnService;
import demo.project.rental.services.QRCodeGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.io.IOException;

@Slf4j
@Service
public class BookReturnServiceImpl implements BookReturnService {

    private static final String QR_CODE_IMAGE_PATH = "./";
    private final StationRepository stationRepository;

    private final VehicleRepository vehicleRepository;

    private final QRCodeGenerationService qrCodeGenerationService;

    @Autowired
    public BookReturnServiceImpl(StationRepository stationRepository, VehicleRepository vehicleRepository, QRCodeGenerationService qrCodeGenerationService){
        this.stationRepository = stationRepository;
        this.vehicleRepository = vehicleRepository;
        this.qrCodeGenerationService = qrCodeGenerationService;
    }

    @Override
    public String bookVehicleFromStation(BookReturnRequest bookReturnRequest) {
        VehicleDetailsInfo vehicleDetailsInfo = vehicleRepository.findByQRCode(bookReturnRequest.getQrCode());
        if(!vehicleDetailsInfo.atStation().equals(bookReturnRequest.getAtStation())){
            throw new BadRequestException("INVALID_REQUEST");
        }
        VehicleDetailsInfo newVehicleDetailsInfo = VehicleDetailsInfo.builder()
                .id(vehicleDetailsInfo.id())
                .vehicleUUID(vehicleDetailsInfo.vehicleUUID())
                .vehicleNumber(vehicleDetailsInfo.vehicleNumber())
                .availability(vehicleDetailsInfo.availability())
                .atStation("BOOKED")
                .qrCode(vehicleDetailsInfo.qrCode())
                .build();

//        VehicleDetailsInfo vehicleDetailsInfo = VehicleDetailsInfo.builder()
//                .id(123L)
//                .vehicleUUID("123")
//                .vehicleNumber("1")
//                .availability("yes")
//                .atStation("3")
//                .qrCode("QR")
//                .build();

        vehicleDetailsInfo = vehicleRepository.save(newVehicleDetailsInfo);
        try {
            qrCodeGenerationService.generateQRCodeImage(vehicleDetailsInfo, 250, 250, QR_CODE_IMAGE_PATH);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "BOOKED";
    }

    @Override
    public String returnVehicleToStation(BookReturnRequest bookReturnRequest){
        VehicleDetailsInfo vehicleDetailsInfo = vehicleRepository.findByQRCode(bookReturnRequest.getQrCode());
        if(!vehicleDetailsInfo.atStation().equals("BOOKED")){
            throw new BadRequestException("INVALID_REQUEST");
        }
        VehicleDetailsInfo newVehicleDetailsInfo = VehicleDetailsInfo.builder()
                .id(vehicleDetailsInfo.id())
                .vehicleUUID(vehicleDetailsInfo.vehicleUUID())
                .vehicleNumber(vehicleDetailsInfo.vehicleNumber())
                .availability(vehicleDetailsInfo.availability())
                .atStation(bookReturnRequest.getAtStation())
                .qrCode(vehicleDetailsInfo.qrCode())
                .build();

        vehicleDetailsInfo = vehicleRepository.save(newVehicleDetailsInfo);
        return "RETURNED";
    }
}
