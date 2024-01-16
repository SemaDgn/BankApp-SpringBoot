package com.folksdevbank.folksdevbank.service;

import com.folksdevbank.folksdevbank.dto.AccountDto;
import com.folksdevbank.folksdevbank.dto.AccountDtoConverter;
import com.folksdevbank.folksdevbank.dto.CreateAccountRequest;
import com.folksdevbank.folksdevbank.dto.UpdateAccountRequest;
import com.folksdevbank.folksdevbank.model.Account;
import com.folksdevbank.folksdevbank.model.Customer;
import com.folksdevbank.folksdevbank.repository.AccountRepositroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AccountService {

    private final AccountRepositroy accountRepositroy;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepositroy accountRepositroy, CustomerService customerService, AccountDtoConverter accountDtoConverter) {
        this.accountRepositroy = accountRepositroy;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.getCustomerById(createAccountRequest.getId());
        if (customer.getId() == null || customer.getId() == "")
            return AccountDto.builder().build();
        Account account = Account.builder()
                .id(createAccountRequest.getId())
                .balance(createAccountRequest.getBalance())
                .currency(createAccountRequest.getCurrency())
                .customerId(createAccountRequest.getCustomerId())
                .city(createAccountRequest.getCity())
                .build();
        return accountDtoConverter.convert(accountRepositroy.save(account));
    }
    public AccountDto updateAccount(String id, UpdateAccountRequest request)
    {
        Customer customer = customerService.getCustomerById(request.getCustomerId());
        if (customer.getId() == null || customer.getId() == "")
            return AccountDto.builder().build();

        Optional<Account> accountOptional=accountRepositroy.findById(id);
        accountOptional.ifPresent(account->{
            account.setBalance(request.getBalance());
            account.setCity(request.getCity());
            account.setCurrency(request.getCurrency());
            account.setCustomerId(request.getCustomerId());
            accountRepositroy.save(account);
        });

        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

    public List<AccountDto>  getAllAccounts()
    {
        List<Account> accountList=accountRepositroy.findAll();
        return accountList.stream().map(accountDtoConverter::convert).collect(Collectors.toList());
    }
    public AccountDto getAccountById(String id)
    {
        return accountRepositroy.findById(id).map(accountDtoConverter::convert).orElse(new AccountDto());
    }
    public void deleteAccount(String id)
    {
        accountRepositroy.deleteById(id);
    }

    public AccountDto withDrawMoney(String id,Double amount)
    {
        Optional<Account> accountOptional=accountRepositroy.findById(id);
        accountOptional.ifPresent(account ->
        {
            if (account.getBalance()>amount)
            {
                account.setBalance(account.getBalance()-amount);
                accountRepositroy.save(account);
            }
            else
                System.out.println("Insufficient funds -> accoundId:"+id+" balance :"+ account.getBalance() +" amount :"+ amount);

        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());

    }
    public AccountDto addMoney(String id,Double amount)
    {
        Optional<Account> accountOptional=accountRepositroy.findById(id);
        accountOptional.ifPresent(account ->
        {
                account.setBalance(account.getBalance()+amount);
                accountRepositroy.save(account);

        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

}
