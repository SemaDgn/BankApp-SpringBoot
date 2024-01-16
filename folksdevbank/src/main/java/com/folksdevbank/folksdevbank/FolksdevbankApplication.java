package com.folksdevbank.folksdevbank;

import com.folksdevbank.folksdevbank.dto.CreateCustomerRequest;
import com.folksdevbank.folksdevbank.model.Account;
import com.folksdevbank.folksdevbank.model.City;
import com.folksdevbank.folksdevbank.model.Customer;
import com.folksdevbank.folksdevbank.repository.AccountRepositroy;
import com.folksdevbank.folksdevbank.repository.CustomerRepository;
import com.folksdevbank.folksdevbank.service.AccountService;
import com.folksdevbank.folksdevbank.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FolksdevbankApplication implements CommandLineRunner {

	private final AccountRepositroy accountRepositroy;
	private final CustomerRepository customerRepository;

	public FolksdevbankApplication(AccountRepositroy accountRepositroy, CustomerRepository customerRepository) {
		this.accountRepositroy = accountRepositroy;
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FolksdevbankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = Customer.builder()
				.id("123")
				.name("Çağri")
				.city(City.ISTANBUL)
				.address("Ev")
				.dateOfBirth(1988)
				.build();
		Customer c2 = Customer.builder()
				.id("456")
				.name("Sema")
				.city(City.KOCAELI)
				.address("Ev")
				.dateOfBirth(1992)
				.build();
		Customer c3 = Customer.builder()
				.id("789")
				.name("Lokman")
				.city(City.KOCAELI)
				.address("Is")
				.dateOfBirth(1986)
				.build();

		customerRepository.saveAll(Arrays.asList(c1,c2,c3));

		Account a1= Account.builder()
				.id("100")
				.customerId("123")
				.city(City.ISTANBUL)
				.balance(132.0)
				.build();
		Account a2= Account.builder()
				.id("101")
				.customerId("456")
				.city(City.KOCAELI)
				.balance(7898.0)
				.build();

		Account a3= Account.builder()
				.id("102")
				.customerId("789")
				.city(City.KOCAELI)
				.balance(120000.0)
				.build();

		accountRepositroy.saveAll(Arrays.asList(a1,a2,a3));

	}
}
