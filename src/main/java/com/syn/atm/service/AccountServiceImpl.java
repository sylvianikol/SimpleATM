package com.syn.atm.service;

import com.syn.atm.model.Account;
import com.syn.atm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.syn.atm.common.constantMessages.*;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CardService cardService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CardService cardService) {
        this.accountRepository = accountRepository;
        this.cardService = cardService;
    }

    @Override
    public String withdraw(String cardNumber, BigDecimal amount) {

        String accountId = cardService.getCardAccountId(cardNumber);
        Account account = accountRepository.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        BigDecimal updatedBalance = account.getBalance().subtract(amount);
        account.setBalance(updatedBalance);

        return WITHDRAW_SUCCESS + CURRENT_BALANCE + account.getBalance();
    }

    @Override
    public String deposit(String cardNumber, BigDecimal ammount) {

        String accountId = cardService.getCardAccountId(cardNumber);
        Account account = accountRepository.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        BigDecimal updatedBalance = account.getBalance().add(ammount);
        account.setBalance(updatedBalance);

        return DEPOSIT_SUCCESS + CURRENT_BALANCE + account.getBalance();
    }

    @Override
    public String checkBalance(String cardNumber) {

        String accountId = cardService.getCardAccountId(cardNumber);
        Account account = accountRepository.getAccount(accountId);

        if (account == null) {
            return ACCOUNT_NOT_FOUND;
        }

        return CURRENT_BALANCE + account.getBalance();
    }
}
