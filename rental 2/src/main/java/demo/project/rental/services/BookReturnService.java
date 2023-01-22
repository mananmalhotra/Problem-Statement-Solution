package demo.project.rental.services;

import com.google.zxing.WriterException;
import demo.project.rental.pojos.BookReturnRequest;

import java.io.IOException;

public interface BookReturnService {

    public String bookVehicleFromStation(BookReturnRequest bookReturnRequest);

    public String returnVehicleToStation(BookReturnRequest bookReturnRequest);
}
