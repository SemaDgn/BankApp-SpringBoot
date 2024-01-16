package com.folksdevbank.folksdevbank.dto;

import com.folksdevbank.folksdevbank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {
    public AccountDto convert(Account account)
    {
       return AccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .customerId(account.getCustomerId())
                .build();//@builder lombook
    }
}
