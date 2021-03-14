package com.syn.atm.service;

import com.syn.atm.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public String getCardAccountId(String cardNumber) {
        return this.cardRepository.get(cardNumber).getAccountId();
    }
}
