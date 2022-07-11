package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class RegisteredCustomer {
    @Id
    String rcId;
    String name;
    String contact;
    String email;
    String nic;
    String username;
    String password;
}
