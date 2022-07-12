package lk.ijse.spring.repo;

import lk.ijse.spring.entity.GuestCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestCustomerRepo extends JpaRepository<GuestCustomer, String> {
}
