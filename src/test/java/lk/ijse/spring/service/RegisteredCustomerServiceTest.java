package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.RegisteredCustomer;
import lk.ijse.spring.repo.RegisteredCustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration // State test configuration class
@ContextConfiguration(classes = {JPAConfig.class}) // import configurations for Test Context
@ExtendWith(SpringExtension.class) // Run with Spring Extension
//@Transactional
class RegisteredCustomerServiceTest {
    @Autowired
    RegisteredCustomerRepo repo;

    @Test
    void saveRegisteredCustomer() {
        RegisteredCustomer registeredCustomer = new RegisteredCustomer("RC001", "dfsf", "dfsfsgfs", "fjgfhdhd", "dsfsfs", "fgsdfsf", "dfsfs");
        repo.save(registeredCustomer);
    }

    @Test
    void deleteRegisteredCustomer() {
    }

    @Test
    void updateRegisteredCustomer() {
    }

    @Test
    void searchRegisteredCustomer() {
    }

    @Test
    void getAllRegisteredCustomer() {
    }
}