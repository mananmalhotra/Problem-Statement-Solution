package demo.project.rental.repositories;

import demo.project.rental.models.OTPDetailsInfo;
import demo.project.rental.models.VehicleDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleDetailsInfo, Long> {

    @Query(value = "select * from vehicle where at_station = ?1", nativeQuery = true)
    List<VehicleDetailsInfo> findAllByLocation(String location);

    @Query(value = "select * from vehicle where qr_code = ?1", nativeQuery = true)
    VehicleDetailsInfo findByQRCode(String qr_code);
}
