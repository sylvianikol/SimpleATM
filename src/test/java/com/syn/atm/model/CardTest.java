package com.syn.atm.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void canInstantiateCard() {
        Card card = new Card();
        assertNotNull(card);
    }

    @Test
    void canInstantiateCardWithParams() {
        Card card = new Card("123", "1111", "1");
        assertNotNull(card);
    }

    @Test
    void getPINNotNull() {
        Card card = new Card("123", "1111", "1");
        assertNotNull(card.getPIN());
    }

    @Test
    void getPINReturnsCorrectPIN() {
        Card card = new Card("123", "1111", "1");
        String expected = card.getPIN();
        assertEquals(expected, "1111");
    }

    @Test
    void getAccountIdNotNull() {
        Card card = new Card("123", "1111", "1");
        assertNotNull(card.getAccountId());
    }

    @Test
    void getAccountIdReturnsCorrectId() {
        Card card = new Card("123", "1111", "1");
        String expected = card.getAccountId();
        assertEquals(expected, "1");
    }
}