
package com.folksdevbank.folksdevbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity(name = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    private String id;
    //@Column(name = "musteri_ismi")
    private String name;
    private Integer dateOfBirth;
    private City city;
    private String address;

}
