package com.syn.atm.repository;

import com.syn.atm.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public class AccountRepository {

    private final Map<String, Account> accounts;

    public AccountRepository() {
        this.accounts = Map.of(
                "1", new Account("1", BigDecimal.TEN),
                "2", new Account("2", BigDecimal.ONE),
                "3", new Account("3", BigDecimal.ZERO)
        );
    }

    public Account getAccount(String accountId) {
        return this.accounts.get(accountId);
    }

}
