package demo.project.rental.controllers;

import demo.project.rental.pojos.BaseResponse;
import demo.project.rental.pojos.BookReturnRequest;
import demo.project.rental.services.BookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rent")
public class BookReturnController {

    private final BookReturnService bookReturnService;

    @Autowired
    public BookReturnController(BookReturnService bookReturnService){
        this.bookReturnService = bookReturnService;
    }

    @PostMapping("/book")
    public ResponseEntity<BaseResponse<String>> bookVehicle(
            @Valid @RequestBody BookReturnRequest bookReturnRequest){
        return new ResponseEntity<>(new BaseResponse<>("success", bookReturnService.bookVehicleFromStation(bookReturnRequest)), HttpStatus.CREATED);
    }

    @PostMapping("/return")
    public ResponseEntity<BaseResponse<String>> returnVehicle(
            @Valid @RequestBody BookReturnRequest bookReturnRequest){
        return new ResponseEntity<>(new BaseResponse<>("success", bookReturnService.returnVehicleToStation(bookReturnRequest)), HttpStatus.CREATED);
    }
}
