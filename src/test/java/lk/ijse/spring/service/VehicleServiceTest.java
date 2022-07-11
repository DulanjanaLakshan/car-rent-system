package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Vehicle;
import lk.ijse.spring.repo.VehicleRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration // State test configuration class
@ContextConfiguration(classes = {JPAConfig.class}) // import configurations for Test Context
@ExtendWith(SpringExtension.class) // Run with Spring Extension
//@Transactional
class VehicleServiceTest {

    @Autowired
    VehicleRepo repo;

    @Test
    void saveVehicle() {
        Vehicle vehicle = new Vehicle("V001","sada","dfsgsd","fdshgewr","egesdf","dsfsgagggfgsd","sdafggggsaggf");
        repo.save(vehicle);
    }

    @Test
    void deleteVehicle() {
    }

    @Test
    void updateVehicle() {
    }

    @Test
    void searchVehicle() {
    }

    @Test
    void getAllVehicle() {
    }
}