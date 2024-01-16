package com.folksdevbank.folksdevbank.repository;

import com.folksdevbank.folksdevbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
