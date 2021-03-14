package com.syn.atm.validation;

import com.syn.atm.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements Validator {

    private final CardRepository cardRepository;

    @Autowired
    public ValidatorImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public boolean isValid(String cardNumber, String PIN) {
        return cardRepository.get(cardNumber).getPIN().equals(PIN);
    }
}
