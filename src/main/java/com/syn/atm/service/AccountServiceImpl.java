package com.syn.atm.service;

import com.syn.atm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
         return accountRepository.withdraw(accountId, amount);

    }

    @Override
    public String deposit(String cardNumber, BigDecimal ammount) {
        String accountId = cardService.getCardAccountId(cardNumber);
        return accountRepository.deposit(accountId, ammount);
    }

    @Override
    public String checkBalance(String cardNumber) {
        String accountId = cardService.getCardAccountId(cardNumber);
        return accountRepository.checkBalance(accountId);
    }
}
