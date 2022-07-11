package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.EmployeeDTO;
import lk.ijse.spring.entity.Employee;
import lk.ijse.spring.repo.EmployeeRepo;
import lk.ijse.spring.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveEmployee(EmployeeDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Employee.class));
        } else {
            throw new RuntimeException("Employee Already Exist..!");
        }
    }

    @Override
    public void deleteEmployee(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please Check the Employee ID.. No Such Employee..!");
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Employee.class));
        } else {
            throw new RuntimeException("No Such Employee To Update..! Please Check The ID..!");
        }
    }

    @Override
    public EmployeeDTO searchEmployee(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), EmployeeDTO.class);
        } else {
            throw new RuntimeException("No Employee For " + id + " ..!");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapper.map(repo.findAll(), new TypeToken<List<EmployeeDTO>>() {
        }.getType());

    }
}
