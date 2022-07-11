package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Drivers;
import lk.ijse.spring.repo.DriverRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class DriverServiceTest {
    @Autowired
    DriverRepo repo;

    @Test
    void saveDrivers() {
        Drivers drivers = new Drivers("D001", "Nipuna", "Kalutara", "1122334455", "123456789");
        Drivers drivers2 = new Drivers("D002", "Mishel", "wennapuwa", "312115416141", "784645131316");
        repo.save(drivers);
        repo.save(drivers2);
    }

    @Test
    void deleteDrivers() {
        repo.deleteById("D001");
    }

    @Test
    void updateDrivers() {
        Drivers drivers2 = new Drivers("D001", "Mishel", "wennapuwa", "312115416141", "784645131316");
        repo.save(drivers2);
    }

    @Test
    void searchDrivers() {
        Optional<Drivers> d = repo.findById("D001");
        boolean present = d.isPresent();
        System.out.print(present);

        Drivers drivers = d.get();
        System.out.println(drivers);
    }

    @Test
    void getAllDrivers() {
        List<Drivers> all = repo.findAll();
        for (Drivers drivers : all) {
            System.out.println(drivers.toString());
        }
    }
}