package lk.ijse.spring.service;

import lk.ijse.spring.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO dto);
    void deleteEmployee(String id);
    void updateEmployee(EmployeeDTO dto);
    EmployeeDTO searchEmployee(String id);
    List<EmployeeDTO> getAllEmployee();
}
