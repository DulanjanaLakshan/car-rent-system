package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RegisteredCustomerDTO;
import lk.ijse.spring.entity.RegisteredCustomer;
import lk.ijse.spring.repo.RegisteredCustomerRepo;
import lk.ijse.spring.service.RegisteredCustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        if (!repo.existsById(dto.getRcId())) {
            repo.save(mapper.map(dto, RegisteredCustomer.class));
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteRegisteredCustomer(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateRegisteredCustomer(RegisteredCustomerDTO dto) {
        if (repo.existsById(dto.getRcId())) {
            repo.save(mapper.map(dto, RegisteredCustomer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public RegisteredCustomerDTO searchRegisteredCustomer(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), RegisteredCustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<RegisteredCustomerDTO> getAllRegisteredCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<List<RegisteredCustomerDTO>>() {
        }.getType());
    }
}
