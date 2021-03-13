package com.syn.atm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    private Account ACCOUNT;
    private String ID;
    private String PIN;

    @BeforeEach
    public void setUp() {
        ACCOUNT = new Account("123", BigDecimal.TEN);
        ID = "456";
        PIN = "789";
    }

    @Test
    public void canInstantiateCreditCard() {
        CreditCard card = new CreditCard();
        assertNotNull(card);
    }

    @Test
    public void canInstantiateCardWithParams() {
        CreditCard card = new CreditCard(ID, PIN, ACCOUNT);
        assertNotNull(card);
    }

    @Test
    public void getIdReturnsString() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        String returned = creditCard.getId();
        assertNotNull(returned);
    }

    @Test
    public void getIdReturnsCorrectId() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        String expected = creditCard.getId();
        assertEquals(expected, ID);
    }

    @Test
    public void getPINReturnsString() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        String returned = creditCard.getPIN();
        assertNotNull(returned);
    }

    @Test
    public void getPINReturnsCorrectpin() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        String expected = creditCard.getPIN();
        assertEquals(expected, PIN);
    }
    @Test
    public void getAccountReturnsAccount() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        Account returned = creditCard.getAccount();
        assertNotNull(returned);
    }

    @Test
    public void getAccountReturnsCorrectAccount() {
        CreditCard creditCard = new CreditCard(ID, PIN, ACCOUNT);
        Account expected = creditCard.getAccount();
        assertEquals(expected, ACCOUNT);
    }

}
