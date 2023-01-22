package demo.project.rental.services;

import com.google.zxing.WriterException;
import demo.project.rental.models.VehicleDetailsInfo;

import java.io.IOException;

public interface QRCodeGenerationService {
    public void generateQRCodeImage(VehicleDetailsInfo vehicleDetailsInfo, int width, int height, String filePath) throws WriterException,IOException;

    public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException;
}
