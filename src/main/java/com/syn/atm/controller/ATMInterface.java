package com.syn.atm.controller;

import com.syn.atm.enums.OperationType;
import com.syn.atm.service.AccountService;
import com.syn.atm.validation.Validator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

import static com.syn.atm.common.constantMessages.*;

@Component
public class ATMInterface implements CommandLineRunner {

    private final AccountService accountService;
    private final Validator validator;
    private final BufferedReader reader;

    public ATMInterface(AccountService accountService, Validator validator, BufferedReader reader) {
        this.accountService = accountService;
        this.validator = validator;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ENTER_CARD_NO);
        String cardNumber = reader.readLine();

        String message;

        System.out.println(CHOOSE_OPERATION);
        OperationType operationType = readOperation();

        switch (operationType) {
             case WITHDRAW: {
                 long input = Long.parseLong(reader.readLine());
                 BigDecimal amount = BigDecimal.valueOf(input);

                 System.out.println(ENTER_PIN);
                 String PIN = reader.readLine();

                 if (validator.isValid(cardNumber, PIN)) {
                     message = accountService.withdraw(cardNumber, amount);
                 } else {
                     message = INVALID_PIN;
                 }

                 break;
             }
             case DEPOSIT: {
                 long input = Long.parseLong(reader.readLine());
                 BigDecimal amount = BigDecimal.valueOf(input);

                 System.out.println(ENTER_PIN);
                 String PIN = reader.readLine();

                 if (validator.isValid(cardNumber, PIN)) {
                     message = accountService.deposit(cardNumber, amount);
                 } else {
                     message = INVALID_PIN;
                 }

                 break;
             }
             case CHECK: {
                 System.out.println(ENTER_PIN);
                 String PIN = reader.readLine();

                 if (validator.isValid(cardNumber, PIN)) {
                     message = accountService.checkBalance(cardNumber);
                 } else {
                     message = INVALID_PIN;
                 }

                 break;
             }
             case INVALID:
             default: {
                 message = INVALID_OPERATION;
             }
        }

        System.out.println(message);
    }

    private OperationType readOperation() throws IOException {
        String input = reader.readLine().toUpperCase();

        if (input.equals(OperationType.valueOf(input).toString())) {
            return OperationType.valueOf(input);
        }

        return OperationType.INVALID;
    }
}
