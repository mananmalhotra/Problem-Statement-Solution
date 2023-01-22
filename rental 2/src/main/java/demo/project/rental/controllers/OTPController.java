package demo.project.rental.controllers;

import demo.project.rental.pojos.BaseResponse;
import demo.project.rental.repositories.OTPRepository;
import demo.project.rental.services.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OTPController {

    private final OTPService otpService;

    private final OTPRepository otpRepository;

    @Autowired
    public OTPController(OTPService otpService, OTPRepository otpRepository){
        this.otpService = otpService;
        this.otpRepository = otpRepository;
    }

    @PostMapping("/generate")
    public ResponseEntity<BaseResponse<String>> generateOTP(
            @RequestHeader String phone){
        return new ResponseEntity<>(new BaseResponse<>("success", otpService.generateOTPByPhone(phone)), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse<String>> updateOTP(
            @RequestHeader String otp,
            @RequestHeader String phone,
            @PathVariable Long id){
        return new ResponseEntity<>(new BaseResponse<>("success", otpService.updateOTPById(phone, otp, id)), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getOTP(
            @RequestHeader String phone){
        return new ResponseEntity<>(otpService.getOTPByPhone(phone), HttpStatus.OK);
    }
}
