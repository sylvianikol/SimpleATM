package com.syn.atm.model;


import java.math.BigDecimal;

public class Account {

    private String id;
    private BigDecimal balance;

    public Account() {
    }

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
}
