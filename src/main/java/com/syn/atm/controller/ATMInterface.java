package com.syn.atm.controller;

import com.syn.atm.enums.OperationType;
import com.syn.atm.service.AccountService;
import com.syn.atm.validation.Validator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;

import static com.syn.atm.common.constantMessages.*;

@Component
public class ATMInterface implements CommandLineRunner {

    private final AccountService accountService;
    private final Validator validator;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public ATMInterface(AccountService accountService, Validator validator, BufferedReader reader, BufferedWriter writer) {
        this.accountService = accountService;
        this.validator = validator;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run(String... args) throws Exception {

        String cardNumber = readCardNumber();
        OperationType operationType = readOperation();

        String message;

        switch (operationType) {
             case WITHDRAW: {

                 BigDecimal amount = readAmount();

                 String PIN = readPIN();

                 if (validator.isValid(cardNumber, PIN)) {
                     message = accountService.withdraw(cardNumber, amount);
                 } else {
                     message = INVALID_PIN;
                 }

                 break;
             }
             case DEPOSIT: {

                 BigDecimal amount = readAmount();

                 String PIN = readPIN();

                 if (validator.isValid(cardNumber, PIN)) {
                     message = accountService.deposit(cardNumber, amount);
                 } else {
                     message = INVALID_PIN;
                 }

                 break;
             }
             case CHECK: {

                 String PIN = readPIN();

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

        print(message);
    }

    private void prompt(String message) throws IOException {
        switch (message) {
            case ENTER_PIN:
                writer.write(ENTER_PIN);
                break;
            case ENTER_AMOUNT:
                writer.write(ENTER_AMOUNT);
                break;
            case ENTER_CARD_NO:
                writer.write(ENTER_CARD_NO);
                break;
            case CHOOSE_OPERATION:
                writer.write(CHOOSE_OPERATION);
                break;
            default:
                writer.write(OUTPUT_ERROR);
        }

        writer.flush();
    }

    private void print(String output) throws IOException {
        writer.write(output);
        writer.flush();
    }

    private String readPIN() throws IOException {
        prompt(ENTER_PIN);
        return reader.readLine();
    }

    private BigDecimal readAmount() throws IOException {
        prompt(ENTER_AMOUNT);
        long input = Long.parseLong(reader.readLine());
        return BigDecimal.valueOf(input);
    }

    private String readCardNumber() throws IOException {
        prompt(ENTER_CARD_NO);
        return reader.readLine();
    }

    private OperationType readOperation() throws IOException {
        prompt(CHOOSE_OPERATION);

        String input = reader.readLine().toUpperCase();
        String type;

        try {
            type = OperationType.valueOf(input).toString();
            if (input.equals(type)) {
                return OperationType.valueOf(input);
            }
        } catch (IllegalArgumentException ex) {
            writer.write(ex.getMessage());
            writer.flush();
        }

        return OperationType.INVALID;
    }
}
