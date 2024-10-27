package tn.esprit.ecommerce;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.ecommerce.Address;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document (collection = "customers")
public class Customer {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
