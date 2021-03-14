package com.syn.atm.validation;

public interface Validator {

    boolean isValid(String cardNumber, String PIN);
}
