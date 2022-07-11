package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DamageDTO;
import lk.ijse.spring.entity.Damage;
import lk.ijse.spring.repo.DamageRepo;
import lk.ijse.spring.service.DamageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DamageServiceImpl implements DamageService {

    @Autowired
    private DamageRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDamage(DamageDTO dto) {
        if (!repo.existsById(dto.getId())){
            repo.save(mapper.map(dto, Damage.class));
        }else{
            throw new RuntimeException("Damage Already Exist..!");
        }
    }

    @Override
    public void deleteDamage(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Damage Vehicle ID.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateDamage(DamageDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Damage.class));
        } else {
            throw new RuntimeException("No Such Damage Vehicle To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DamageDTO searchDamage(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), DamageDTO.class);
        } else {
            throw new RuntimeException("No Damage Vehicle For " + id + " ..!");
        }
    }

    @Override
    public List<DamageDTO> getAllDamage() {
        return mapper.map(repo.findAll(), new TypeToken<List<DamageDTO>>() {
        }.getType());
    }
}
