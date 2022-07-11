package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Employee;
import lk.ijse.spring.repo.EmployeeRepo;
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
class EmployeeServiceTest {

    @Autowired
    EmployeeRepo repo;

    @Test
    void saveEmployee() {
        Employee employee = new Employee("E001","dsada","adsada","sadad","fdasgggfa","adfgea","eaeaf");
        repo.save(employee);
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void searchEmployee() {
    }

    @Test
    void getAllEmployee() {
    }
}