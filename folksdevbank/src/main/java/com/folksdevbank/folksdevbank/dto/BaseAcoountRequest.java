package com.folksdevbank.folksdevbank.dto;

import com.folksdevbank.folksdevbank.model.City;
import com.folksdevbank.folksdevbank.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseAcoountRequest {
    private  String customerId;
    private  Double balance;
    private City city;
    private Currency currency;
}
