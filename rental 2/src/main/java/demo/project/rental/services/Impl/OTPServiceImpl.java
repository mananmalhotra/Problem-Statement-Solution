package demo.project.rental.services.Impl;

import demo.project.rental.models.OTPDetailsInfo;
import demo.project.rental.repositories.OTPRepository;
import demo.project.rental.services.OTPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
public class OTPServiceImpl implements OTPService {

    private final OTPRepository otpRepository;

    @Autowired
    public OTPServiceImpl(OTPRepository otpRepository){
        this.otpRepository = otpRepository;
    }

    @Override
    public String generateOTPByPhone(String phone){
        String otp = generateOTP(4);
        if(otpRepository.checkPhoneExistOrNot(phone)!=0){
            OTPDetailsInfo otpDetailsInfo = otpRepository.findByPhone(phone);
            return updateOTPById(phone, otp, otpDetailsInfo.id());
        }else{
            OTPDetailsInfo otpDetailsInfo = OTPDetailsInfo.builder()
                    .otpUUID(UUID.randomUUID().toString())
                    .phone(phone)
                    .otp(otp)
                    .build();

            otpRepository.save(otpDetailsInfo);
        }
        return "OTP Generated";
    }

    public String updateOTPById(String phone, String otp, Long id){
        OTPDetailsInfo otpDetailsInfo = otpRepository.findByPhone(phone);
        OTPDetailsInfo newOTPDetailsInfo = OTPDetailsInfo.builder()
                .id(id)
                .otpUUID(otpDetailsInfo.otpUUID())
                .phone(phone)
                .otp(otp)
                .build();

        otpDetailsInfo = otpRepository.save(newOTPDetailsInfo);

        return "OTP Updated";
    }

    public String getOTPByPhone(String phone){
        OTPDetailsInfo otpDetailsInfo = otpRepository.findByPhone(phone);
        return otpDetailsInfo.otp();
    }

    private static String generateOTP(int length) {
        String numbers = "1234567890";
        Random random = new Random();
        String otp = "";

        for(int i = 0; i< length ; i++) {
            otp += numbers.charAt(random.nextInt(numbers.length()));
        }
        return otp;
    }
}
