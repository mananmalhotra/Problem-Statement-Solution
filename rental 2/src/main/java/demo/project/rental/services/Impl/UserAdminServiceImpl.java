package demo.project.rental.services.Impl;

import demo.project.rental.models.UserDetailsInfo;
import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.UserDetailsRequest;
import demo.project.rental.repositories.OTPRepository;
import demo.project.rental.repositories.UserAdminRepository;
import demo.project.rental.services.UserAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.UUID;

@Service
@Slf4j
public class UserAdminServiceImpl implements UserAdminService {

    private final UserAdminRepository userAdminRepository;

    private final OTPRepository otpRepository;

    @Autowired
    public UserAdminServiceImpl(UserAdminRepository userAdminRepository, OTPRepository otpRepository){
        this.userAdminRepository = userAdminRepository;
        this.otpRepository = otpRepository;
    }

    @Override
    public GenericResponse addUserAdminDetails(UserDetailsRequest userDetailsRequest, String otp){
        if(!otpRepository.findOTPByPhone(userDetailsRequest.getPhone()).equals(otp)){
            throw new BadRequestException("Invalid OTP");
        }
        UserDetailsInfo userDetailsInfo = null;
        if(userDetailsRequest.getRole().isEmpty()){
            userDetailsInfo = UserDetailsInfo.builder()
                    .userUUID(UUID.randomUUID().toString())
                    .name(userDetailsRequest.getName())
                    .phone(userDetailsRequest.getPhone())
                    .email(userDetailsRequest.getEmail())
                    .build();
        }
        else{
            if(!userDetailsRequest.getRole().equals("ADMIN")){
                userDetailsRequest.setRole("USER");
            }
            userDetailsInfo = UserDetailsInfo.builder()
                    .userUUID(UUID.randomUUID().toString())
                    .name(userDetailsRequest.getName())
                    .phone(userDetailsRequest.getPhone())
                    .email(userDetailsRequest.getEmail())
                    .role(userDetailsRequest.getRole())
                    .build();
        }
        userAdminRepository.save(userDetailsInfo);
        return GenericResponse.builder()
                .userUUID(userDetailsInfo.userUUID())
                .build();
    }
}
