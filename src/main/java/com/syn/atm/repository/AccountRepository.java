package com.syn.atm.repository;

import com.syn.atm.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

import static com.syn.atm.common.constantMessages.*;

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

    public String withdraw(String accountId, BigDecimal amount) {

        Account account = this.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        BigDecimal updatedBalance = account.getBalance().subtract(amount);
        account.setBalance(updatedBalance);

        return WITHDRAW_SUCCESS + this.checkBalance(accountId);
    }

    public String deposit(String accountId, BigDecimal ammount) {

        Account account = this.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        BigDecimal updatedBalance = account.getBalance().add(ammount);
        account.setBalance(updatedBalance);

        return DEPOSIT_SUCCESS + this.checkBalance(accountId);
    }

    public String checkBalance(String accountId) {
        Account account = this.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        return CURRENT_BALANCE + account.getBalance();
    }

    private Account getAccount(String accountId) {
        return this.accounts.get(accountId);
    }

}
