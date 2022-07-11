package lk.ijse.spring.service;

import lk.ijse.spring.dto.RegisteredCustomerDTO;

import java.util.List;

public interface RegisteredCustomerService {
    void saveRegisteredCustomer(RegisteredCustomerDTO dto);
    void deleteRegisteredCustomer(String id);
    void updateRegisteredCustomer(RegisteredCustomerDTO dto);
    RegisteredCustomerDTO searchRegisteredCustomer(String id);
    List<RegisteredCustomerDTO> getAllRegisteredCustomer();
}
