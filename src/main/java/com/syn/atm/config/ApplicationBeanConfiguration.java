package com.syn.atm.config;

import com.syn.atm.repository.CardRepository;
import com.syn.atm.validation.Validator;
import com.syn.atm.validation.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ApplicationBeanConfiguration {

    private final CardRepository cardRepository;

    @Autowired
    public ApplicationBeanConfiguration(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Bean
    public Validator validator() {
        return new ValidatorImpl(cardRepository);
    }

    @Bean
    public BufferedReader bufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
