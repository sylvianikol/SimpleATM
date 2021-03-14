package com.syn.atm.repository;

import com.syn.atm.model.Card;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CardRepository {

    private final Map<String, Card> cards;

    public CardRepository() {
        this.cards = Map.of(
                "123", new Card("123", "1111", "1"),
                "345", new Card("345", "2222", "2"),
                "678", new Card("678", "3333", "3")
        );
    }

    public Card get(String cardNumber) {
        return this.cards.get(cardNumber);
    }
}
