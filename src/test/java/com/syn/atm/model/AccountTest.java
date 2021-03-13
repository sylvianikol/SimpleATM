package com.syn.atm.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {

    @Test
    public void canInstantiateAccount() {
        Account account = new Account();
        assertNotNull(account);
    }
}
