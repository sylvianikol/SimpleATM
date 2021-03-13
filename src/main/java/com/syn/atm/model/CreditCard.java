package com.syn.atm.model;

public class CreditCard {

    private String id;
    private String PIN;
    private Account account;

    public CreditCard() {

    }

    public CreditCard(String id, String PIN, Account account) {
        this.id = id;
        this.PIN = PIN;
        this.account = account;
    }

    public String getId() {
        return this.id;
    }

    public String getPIN() {
        return PIN;
    }

    public Account getAccount() {
        return account;
    }
}
