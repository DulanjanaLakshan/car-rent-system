package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepo extends JpaRepository<Damage,String> {
}
