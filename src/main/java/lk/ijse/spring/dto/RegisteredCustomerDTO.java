package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisteredCustomerDTO {
    String rcId;
    String name;
    String contact;
    String email;
    String nic;
    String username;
    String password;
}
