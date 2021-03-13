package com.syn.atm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private String ID;
    private BigDecimal BALANCE;

    @BeforeEach
    public void setUp() {
        ID = "3243242";
        BALANCE = BigDecimal.TEN;
    }

    @Test
    public void canInstantiateAccount() {
        Account account = new Account();
        assertNotNull(account);
    }

    @Test
    public void canInstantiateAccountWithIdAndBalance() {
        Account account = new Account(ID, BALANCE);
        assertNotNull(account);
    }

    @Test
    public void getIdReturnsString() {
        Account account = new Account(ID, BALANCE);
        String returned = account.getId();
        assertNotNull(returned);
    }

    @Test
    public void getIdReturnsCorrectId() {
        Account account = new Account(ID, BALANCE);
        String expected = account.getId();
        assertEquals(expected, ID);
    }

    @Test
    public void getBalanceReturnsBigDecimal() {
        Account account = new Account(ID, BALANCE);
        BigDecimal returned = account.getBalance();
        assertNotNull(returned);
    }

    @Test
    public void getBalanceReturnsCorrectBalance() {
        Account account = new Account(ID, BALANCE);
        BigDecimal expected = account.getBalance();
        assertEquals(expected, BALANCE);
    }
}
