package com.folksdevbank.folksdevbank.repository;

import com.folksdevbank.folksdevbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositroy extends JpaRepository<Account,String> {
}
