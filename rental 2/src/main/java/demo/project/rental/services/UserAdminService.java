package demo.project.rental.services;

import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.UserDetailsRequest;

public interface UserAdminService {

    public GenericResponse addUserAdminDetails(UserDetailsRequest userDetailsRequest, String otp);
}
