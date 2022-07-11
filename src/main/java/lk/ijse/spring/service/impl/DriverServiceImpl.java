package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Drivers;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
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

    }

    @Override
    public void updateDrivers(DriverDTO dto) {

    }

    @Override
    public DriverDTO searchDrivers(String id) {
        return null;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return null;
    }
}
