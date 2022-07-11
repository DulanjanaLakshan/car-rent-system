package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveRent(RentDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Rent.class));
        } else {
            throw new RuntimeException("Rent Vehicle Already Exist..!");
        }
    }

    @Override
    public void deleteRent(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please Check the Rent Vehicle ID.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateRent(RentDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Rent.class));
        } else {
            throw new RuntimeException("No Such Vehicle To Update..! Please Check The ID..!");
        }
    }

    @Override
    public RentDTO searchRent(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), RentDTO.class);
        } else {
            throw new RuntimeException("No Vehicle For " + id + " ..!");
        }
    }

    @Override
    public List<RentDTO> getAllRent() {
        return mapper.map(repo.findAll(), new TypeToken<List<RentDTO>>() {
        }.getType());
    }
}
