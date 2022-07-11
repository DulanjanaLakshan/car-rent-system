package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDTO {
    String id;
    String rcId;
    String vId;
    String dId;
    String description;
    String distance;
    String km;
    Double price;
}
