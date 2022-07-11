package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RegisteredCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredCustomerRepo extends JpaRepository<RegisteredCustomer,String> {
}
