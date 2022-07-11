package lk.ijse.spring.service;

import lk.ijse.spring.dto.DamageDTO;

import java.util.List;

public interface DamageService {
    void saveDamage(DamageDTO dto);
    void deleteDamage(String id);
    void updateDamage(DamageDTO dto);
    DamageDTO searchDamage(String id);
    List<DamageDTO> getAllDamage();
}
