package com.folksdevbank.folksdevbank.service;

import com.folksdevbank.folksdevbank.dto.CreateCustomerRequest;
import com.folksdevbank.folksdevbank.dto.CustomerDto;
import com.folksdevbank.folksdevbank.dto.CustomerDtoConverter;
import com.folksdevbank.folksdevbank.dto.UpdateCustomerRequest;
import com.folksdevbank.folksdevbank.model.City;
import com.folksdevbank.folksdevbank.model.Customer;
import com.folksdevbank.folksdevbank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDto createCustomer(CreateCustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setAddress(customerRequest.getAdress());
        customer.setDateOfBirth(customerRequest.getDateofBirth());
        customer.setCity(City.valueOf(customerRequest.getCity().name()));
        Customer savedCustomer = customerRepository.save(customer);

        return customerDtoConverter.convert(customer);
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDtoList.add(customerDtoConverter.convert(customer));
        }
        return customerDtoList;

    }

    public CustomerDto getCustomerDtoById(String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomer(String id, UpdateCustomerRequest customerRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.ifPresent(customer -> {
            customer.setName(customerRequest.getName());
            customer.setCity(City.valueOf(customerRequest.getCity().name()));
            customer.setAddress(customerRequest.getAdress());
            customer.setDateOfBirth(customerRequest.getDateofBirth());
            customerRepository.save(customer);
        });
        return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());//orelsethrow
    }
    protected Customer getCustomerById(String id)
    {
        return customerRepository.findById(id).orElse(new Customer());

    }
}
