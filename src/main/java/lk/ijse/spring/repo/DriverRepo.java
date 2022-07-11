package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Drivers, String> {
}
