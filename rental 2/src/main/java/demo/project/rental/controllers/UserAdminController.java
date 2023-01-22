package demo.project.rental.controllers;

import demo.project.rental.pojos.BaseResponse;
import demo.project.rental.pojos.GenericResponse;
import demo.project.rental.pojos.UserDetailsRequest;
import demo.project.rental.services.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-admin")
public class UserAdminController {

    private final UserAdminService userAdminService;

    @Autowired
    public UserAdminController(UserAdminService userAdminService){
        this.userAdminService = userAdminService;
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<GenericResponse>> createAdmin(
            @RequestHeader String otp,
            @Valid @RequestBody UserDetailsRequest userDetailsRequest){
        return new ResponseEntity<>(new BaseResponse<GenericResponse>("success", userAdminService.addUserAdminDetails(userDetailsRequest, otp)), HttpStatus.CREATED);
    }
}
