package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RegisteredCustomerDTO;
import lk.ijse.spring.repo.RegisteredCustomerRepo;
import lk.ijse.spring.service.RegisteredCustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegisteredCustomerServiceImpl implements RegisteredCustomerService {

    @Autowired
    private RegisteredCustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveRegisteredCustomer(RegisteredCustomerDTO dto) {

    }

    @Override
    public void deleteRegisteredCustomer(String id) {

    }

    @Override
    public void updateRegisteredCustomer(RegisteredCustomerDTO dto) {

    }

    @Override
    public RegisteredCustomerDTO searchRegisteredCustomer(RegisteredCustomerDTO dto) {
        return null;
    }

    @Override
    public List<RegisteredCustomerDTO> getAllRegisteredCustomer() {
        return null;
    }
}
