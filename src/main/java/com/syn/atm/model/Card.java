package com.syn.atm.model;

public class Card {

    private String number;
    private String PIN;
    private String accountId;

    public Card() { }

    public Card(String number, String PIN, String accountId) {
        this.number = number;
        this.PIN = PIN;
        this.accountId = accountId;
    }

    public String getPIN() {
        return PIN;
    }

    public String getAccountId() {
        return accountId;
    }
}
