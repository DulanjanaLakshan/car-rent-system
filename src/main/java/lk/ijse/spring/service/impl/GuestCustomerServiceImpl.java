package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.GuestCustomerDTO;
import lk.ijse.spring.entity.Drivers;
import lk.ijse.spring.entity.Employee;
import lk.ijse.spring.entity.GuestCustomer;
import lk.ijse.spring.repo.GuestCustomerRepo;
import lk.ijse.spring.service.GuestCustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuestCustomerServiceImpl implements GuestCustomerService {

    @Autowired
    GuestCustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveGuestCustomer(GuestCustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, GuestCustomer.class));
        } else {
            throw new RuntimeException("Employee Already Exist..!");
        }
    }

    @Override
    public void deleteGuestCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please Check the GuestCustomer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateGuestCustomer(GuestCustomerDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, GuestCustomer.class));
        } else {
            throw new RuntimeException("No Such Guest Customer To Update..! Please Check The ID..!");
        }
    }

    @Override
    public GuestCustomerDTO searchGuestCustomer(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), GuestCustomerDTO.class);
        } else {
            throw new RuntimeException("No Guest CustomerDTO For " + id + " ..!");
        }
    }

    @Override
    public List<GuestCustomerDTO> getAllGuestCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<List<GuestCustomerDTO>>() {
        }.getType());
    }
}
