package com.syn.atm.repository;

import com.syn.atm.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.*;

class AccountRepositoryTest {

    private AccountRepository mockedRepository;

    @BeforeEach
    void setUp() {
        mockedRepository = Mockito.mock(AccountRepository.class);
    }

    @Test
    void canInstantiateAccountRepository() {
        assertNotNull(mockedRepository);
    }

    @Test
    void getAccountReturnsNotNull() {
        Account account = new Account("1", BigDecimal.ZERO);
        Mockito.when(mockedRepository.getAccount("1")).thenReturn(account);
        assertNotNull(mockedRepository.getAccount("1"));
    }

    @Test
    void getAccountReturnsAccount() {
        Account account = new Account("1", BigDecimal.ZERO);
        Mockito.when(mockedRepository.getAccount("1")).thenReturn(account);
        Account expected = mockedRepository.getAccount("1");
        assertThat(expected, instanceOf(Account.class));
    }

    @Test
    void getAccountReturnsCorrectAccount() {
        Account actual = new Account("1", BigDecimal.ZERO);
        Mockito.when(mockedRepository.getAccount("1")).thenReturn(actual);

        Account expected = mockedRepository.getAccount("1");

        assertSame(expected, actual);
    }
}