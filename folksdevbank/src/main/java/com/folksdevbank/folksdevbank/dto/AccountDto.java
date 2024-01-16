package com.folksdevbank.folksdevbank.dto;

import com.folksdevbank.folksdevbank.model.City;
import com.folksdevbank.folksdevbank.model.Currency;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private  String id;
    private  String customerId;
    private  Double balance;
    private Currency currency;
}

