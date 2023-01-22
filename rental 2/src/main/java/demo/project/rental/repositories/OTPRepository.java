package demo.project.rental.repositories;

import demo.project.rental.models.OTPDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OTPRepository extends JpaRepository<OTPDetailsInfo, Long> {

    @Query(value = "select * from otp where phone = ?1", nativeQuery = true)
    OTPDetailsInfo findByPhone(String phone);

    @Query(value = "select otp from otp where phone = ?1", nativeQuery = true)
    String findOTPByPhone(String phone);

    @Query(value = "select count(*) from otp where phone = ?1", nativeQuery = true)
    int checkPhoneExistOrNot(String phone);


}
