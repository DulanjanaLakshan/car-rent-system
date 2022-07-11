package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDrivers(DriverDTO dto);
    void deleteDrivers(String id);
    void updateDrivers(DriverDTO dto);
    DriverDTO searchDrivers(String id);
    List<DriverDTO> getAllDrivers();
}
