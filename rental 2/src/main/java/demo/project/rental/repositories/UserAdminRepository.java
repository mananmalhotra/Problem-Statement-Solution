package demo.project.rental.repositories;

import demo.project.rental.models.UserDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdminRepository extends JpaRepository<UserDetailsInfo, Long> {
}
