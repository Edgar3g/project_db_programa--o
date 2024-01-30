package aej.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    private String id;
    private String costumer_name;
    private String nif;
    private String balance_to_pay;
    private String phone_number;

}