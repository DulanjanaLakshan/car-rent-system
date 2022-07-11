package lk.ijse.spring.service;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Damage;
import lk.ijse.spring.repo.DamageRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
class DamageServiceTest {

    @Autowired
    DamageRepo repo;

    @Test
    void saveDamage() {
        Damage damage = new Damage("D001","sdadasda","sadadad","dasdada","dsadada","fdsafsf");
        repo.save(damage);
    }

    @Test
    void deleteDamage() {
        repo.deleteById("D001");
    }

    @Test
    void updateDamage() {
        Damage damage = new Damage("D001","sdadasda","sadadad","dasdada","dsadada","fdsafsf");
        repo.save(damage);
    }

    @Test
    void searchDamage() {
        Optional<Damage> optional = repo.findById("C001");
        boolean present = optional.isPresent();
        System.out.println(present);

        Damage damage = optional.get();
        System.out.println(damage);
    }

    @Test
    void getAllDamage() {
        List<Damage> all = repo.findAll();
        for (Damage damage : all) {
            System.out.println(damage.toString());
        }
    }
}