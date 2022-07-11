package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.entity.Drivers;
import lk.ijse.spring.entity.Vehicle;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDrivers(DriverDTO dto) {
        if (!repo.existsById(dto.getId())){
            repo.save(mapper.map(dto, Drivers.class));
        }else {
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public void deleteDrivers(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please Check the Drivers ID.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateDrivers(DriverDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Drivers.class));
        } else {
            throw new RuntimeException("No Such Drivers To Update..! Please Check The ID..!");
        }
    }

    @Override
    public DriverDTO searchDrivers(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No Driver For " + id + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
