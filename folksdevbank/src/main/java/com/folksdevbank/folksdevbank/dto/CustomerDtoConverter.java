package com.folksdevbank.folksdevbank.dto;

import com.folksdevbank.folksdevbank.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public  CustomerDto convert(Customer customer)
    {
        CustomerDto customerDto= new CustomerDto();
        customerDto.setId(customer.getId());;
        customerDto.setName(customer.getName());
        customerDto.setAdress(customer.getAddress());
        customerDto.setCity(CityDto.valueOf(customer.getCity().name()));
        customerDto.setDateofBirth(customer.getDateOfBirth());
        return customerDto;
    }


}

