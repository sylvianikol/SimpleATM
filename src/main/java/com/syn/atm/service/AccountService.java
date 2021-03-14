package com.syn.atm.service;

import java.math.BigDecimal;

public interface AccountService {

    String withdraw(String cardNumber, BigDecimal ammount);

    String deposit(String cardNumber, BigDecimal ammount);

    String checkBalance(String cardNumber);
}
