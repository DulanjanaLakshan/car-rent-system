package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.repo.RentRepo;
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
class RentServiceTest {

    @Autowired
    RentRepo repo;

    @Test
    void saveRent() {
        Rent rent = new Rent("001","RC001","V001","D001","anuradapuara to tabuthegama","colaba","24km",100.00);
        repo.save(rent);
    }

    @Test
    void deleteRent() {
    }

    @Test
    void updateRent() {
    }

    @Test
    void searchRent() {
    }

    @Test
    void getAllRent() {
    }
}