package demo.project.rental.repositories;

import demo.project.rental.models.StationDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<StationDetailsInfo, Long> {
}
