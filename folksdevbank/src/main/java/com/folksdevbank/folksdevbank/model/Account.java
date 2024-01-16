package com.folksdevbank.folksdevbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity()
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    private  String id;
    private  String customerId;
    private  Double balance;
    private City city;
    private Currency currency;


}
