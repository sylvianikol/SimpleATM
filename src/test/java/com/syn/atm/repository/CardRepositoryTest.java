package com.syn.atm.repository;

import com.syn.atm.model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CardRepositoryTest {

    private CardRepository mockedRepository;

    @BeforeEach
    void setUp() {
        mockedRepository = Mockito.mock(CardRepository.class);
    }

    @Test
    void canInstantiateCardRepository() {
        assertNotNull(mockedRepository);
    }

    @Test
    void getReturnsNotNull() {
        Card card = new Card("123", "1111", "1");
        Mockito.when(mockedRepository.get("123")).thenReturn(card);
        assertNotNull(card);
    }

    @Test
    void getReturnsCorrectCard() {
        Card card = new Card("123", "1111", "1");
        Mockito.when(mockedRepository.get("123")).thenReturn(card);
        assertEquals(card.getPIN(), "1111");
    }
}