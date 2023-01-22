package demo.project.rental.services;

import demo.project.rental.pojos.GenericResponse;

public interface OTPService {

    public String generateOTPByPhone(String phone);

    public String updateOTPById(String phone, String otp, Long id);

    public String getOTPByPhone(String phone);
}
